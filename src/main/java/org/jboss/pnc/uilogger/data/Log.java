package org.jboss.pnc.uilogger.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "uilogs")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "stack")
    private String stack;

    public Log() {

    }

}
