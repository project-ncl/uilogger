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
    private String message;
    private Error error;

    public WebLog() {
    }

    public WebLog(Client client, User user, String url, String data, String message, Error error) {
        this.client = client;
        this.user = user;
        this.url = url;
        this.data = data;
        this.message = message;
        this.error = error;
    }
}
