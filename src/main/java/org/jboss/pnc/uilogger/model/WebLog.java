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
    private String label;
    private Error error;

    public WebLog() {
    }

    public WebLog(
            String id,
            Client client,
            String data,
            Error error,
            String label,
            String message,
            String timestamp,
            String url,
            User user) {
        this(client, user, url, data, message, label, error);
        this.id = id;
        this.timestamp = timestamp;
    }

    public WebLog(Client client, User user, String url, String data, String message, String label, Error error) {
        this.client = client;
        this.user = user;
        this.url = url;
        this.data = data;
        this.message = message;
        this.label = label;
        this.error = error;
    }
}
