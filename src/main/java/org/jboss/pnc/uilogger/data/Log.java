package org.jboss.pnc.uilogger.data;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "uilogs")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "client_version")
    private String clientVersion;

    @Column(name = "client_revision")
    private String clientRevision;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_browser")
    private String userBrowser;

    @Column(name = "user_language")
    private String userLanguage;

    @Column(name = "url")
    private String url;

    @Column(name = "data")
    private String data;

    @Column(name = "message")
    private String message;

    @Column(name = "label")
    private String label;

    @Column(name = "error_name")
    private String errorName;

    @Column(name = "error_stack")
    private String errorStack;

    @Column(name = "error_message")
    private String errorMessage;

    public Log() {

    }

}
