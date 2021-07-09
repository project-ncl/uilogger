package org.jboss.pnc.uilogger.model;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String browser;
    private String language;

    public User() {
    }

    public User(String userId, String browser, String language) {
        this.userId = userId;
        this.browser = browser;
        this.language = language;
    }
}
