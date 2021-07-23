package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Slf4j
@Path("/")
public class Root {

    @Operation(hidden = true)
    @GET
    public String wellcome() {
        return "Hey there.";
    }
}
