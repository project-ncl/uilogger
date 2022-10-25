package org.jboss.pnc.uilogger.model;

import lombok.Data;

@Data
public class Error {

    private String name;

    private String message;

    private String stack;

    public Error() {
    }

    public Error(String name, String message, String stack) {
        this.name = name;
        this.message = message;
        this.stack = stack;
    }

}
