package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Slf4j
@Path("/")
public class Root {

    @Operation(hidden = true)
    @GET
    public String wellcome() {
        return "Hey there.";
    }
}
