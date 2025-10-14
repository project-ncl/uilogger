package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.pnc.api.dto.ComponentVersion;
import org.jboss.pnc.uilogger.app.AppInfo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Path("/")
public class Root {

    @ConfigProperty(name = "quarkus.application.name")
    String name;

    @Operation(hidden = true)
    @GET
    public String wellcome() {
        return "Hey there.";
    }

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
}
