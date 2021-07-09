package org.jboss.pnc.uilogger.model;

import lombok.Data;

@Data
public class WebLog {
    private String id;
    private String timestamp;
    private Client client;
    private User user;
    private String url;

    private String data;

    private String name;
    private String message;
    private String stack;

    public WebLog() {
    }

    public WebLog(Client client, User user, String url, String data, String name, String message, String stack) {
        this.client = client;
        this.user = user;
        this.url = url;
        this.data = data;
        this.name = name;
        this.message = message;
        this.stack = stack;
    }
}
