package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.pnc.uilogger.app.AppInfo;
import org.jboss.pnc.uilogger.data.map.DTOConvertor;
import org.jboss.pnc.uilogger.data.LogRepository;
import org.jboss.pnc.uilogger.model.WebLog;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogRest {

    @Inject
    private LogRepository logRepository;

    @Inject
    DTOConvertor dtoConvertor;

    @Operation(hidden = true, summary = "Gets currently running version of ui logger")
    @Path("/version")
    @GET
    public Response version() {
        return Response.ok().entity("UILogger is running. " + AppInfo.getAppInfoString()).build();
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
    public Response getLogs() {
        List<WebLog> logs = logRepository.getAll()
                .stream()
                .map(log -> dtoConvertor.fromLog(log))
                .collect(Collectors.toList());
        return Response.ok().entity(logs).build();
    }

}
