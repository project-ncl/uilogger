package org.jboss.pnc.uilogger.data.map;

import org.jboss.pnc.uilogger.data.Log;
import org.jboss.pnc.uilogger.model.Client;
import org.jboss.pnc.uilogger.model.Error;
import org.jboss.pnc.uilogger.model.User;
import org.jboss.pnc.uilogger.model.WebLog;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class DTOConvertorImpl implements DTOConvertor {

    public Log toLog(WebLog webLog) {
        Log log = new Log();
        log.setTimestamp(webLog.getTimestamp());
        log.setClientName(webLog.getClient().getName());
        log.setClientVersion(webLog.getClient().getVersion());
        log.setClientRevision(webLog.getClient().getRevision());
        log.setUserId(webLog.getUser().getUserId());
        log.setUserBrowser(webLog.getUser().getBrowser());
        log.setUserLanguage(webLog.getUser().getLanguage());
        log.setUrl(webLog.getUrl());
        log.setData(webLog.getData());
        log.setMessage(webLog.getMessage());
        log.setLabel(webLog.getLabel());
        if (webLog.getError() != null) {
            log.setErrorName(webLog.getError().getName());
            log.setErrorStack(webLog.getError().getStack());
            log.setErrorMessage(webLog.getError().getMessage());
        }
        return log;
    }

    public WebLog fromLog(Log log) {
        WebLog webLog = new WebLog();
        webLog.setClient(new Client(log.getClientVersion(), log.getClientRevision(), log.getClientName()));
        webLog.setUser(new User(log.getUserId(), log.getUserBrowser(), log.getUserLanguage()));
        webLog.setError(new Error(log.getErrorName(), log.getErrorMessage(), log.getErrorStack()));
        webLog.setId(log.getId().toString());
        webLog.setTimestamp(log.getTimestamp());
        webLog.setUrl(log.getUrl());
        webLog.setData(log.getData());
        webLog.setMessage(log.getMessage());
        webLog.setLabel(log.getLabel());
        return webLog;
    }
}
