package org.jboss.pnc.uilogger.rest;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Slf4j
@Path("/")
public class Root {

    @GET
    public String wellcome() {
        return "Hey there.";
    }
}
