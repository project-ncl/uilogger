package org.jboss.pnc.uilogger.model;

import lombok.Data;

@Data
public class Client {
    private String version;
    private String revision;
    private String name;

    public Client() {

    }

    public Client(String version, String revision, String name) {
        this.version = version;
        this.revision = revision;
        this.name = name;
    }
}
