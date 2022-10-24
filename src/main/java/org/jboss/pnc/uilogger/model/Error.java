package org.jboss.pnc.uilogger.model;

import lombok.Data;

@Data
public class Error {

    private String name;

    private String errorMessage;

    private String stack;

    public Error() {
    }

    public Error(String name, String errorMessage, String stack) {
        this.name = name;
        this.errorMessage = errorMessage;
        this.stack = stack;
    }

}
