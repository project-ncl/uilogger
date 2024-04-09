package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.pnc.api.dto.ComponentVersion;
import org.jboss.pnc.uilogger.app.AppInfo;
import org.jboss.pnc.uilogger.data.map.DTOConvertor;
import org.jboss.pnc.uilogger.data.LogRepository;
import org.jboss.pnc.uilogger.model.Order;
import org.jboss.pnc.uilogger.model.WebLog;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Path("/rest")
public class LogRest {

    @ConfigProperty(name = "quarkus.application.name")
    String name;

    @Inject
    private LogRepository logRepository;

    @Inject
    DTOConvertor dtoConvertor;

    @Operation(hidden = true, summary = "Gets currently running version of ui logger")
    @Path("/version")
    @GET
    public ComponentVersion version() {
        return ComponentVersion.builder()
                .name(name)
                .version(AppInfo.getVersion())
                .commit(AppInfo.getRevision())
                .builtOn(
                        ZonedDateTime
                                .parse(AppInfo.getBuildTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")))
                .build();
    }

    @Operation(summary = "Creates a new log.")
    @Path("/logs")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response collectLog(WebLog webLog) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        webLog.setTimestamp(timestamp.toString());
        logRepository.save(dtoConvertor.toLog(webLog));
        log.debug("Saving log: {}", webLog.toString());
        return Response.ok().build();
    }

    @Operation(summary = "Gets all logs.")
    @Path("/logs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogs(
            @QueryParam("pageIndex") @DefaultValue("0") Integer page,
            @QueryParam("pageSize") @DefaultValue("50") Integer size,
            @QueryParam("sort") @DefaultValue("DESC") Order sort) {
        List<WebLog> logs = logRepository.getAll(page, size, sort)
                .stream()
                .map(log -> dtoConvertor.fromLog(log))
                .collect(Collectors.toList());
        return Response.ok().entity(logs).build();
    }

}
