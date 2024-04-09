package org.jboss.pnc.uilogger.data.map;

import org.jboss.pnc.uilogger.data.Log;
import org.jboss.pnc.uilogger.model.Client;
import org.jboss.pnc.uilogger.model.Error;
import org.jboss.pnc.uilogger.model.User;
import org.jboss.pnc.uilogger.model.WebLog;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class DTOConvertorImpl implements DTOConvertor {

    public Log toLog(WebLog webLog) {
        Log log = new Log();
        log.setTimestamp(webLog.getTimestamp());
        log.setClientName(webLog.getClient().name());
        log.setClientVersion(webLog.getClient().version());
        log.setClientRevision(webLog.getClient().revision());
        log.setUserId(webLog.getUser().userId());
        log.setUserBrowser(webLog.getUser().browser());
        log.setUserLanguage(webLog.getUser().language());
        log.setUrl(webLog.getUrl());
        log.setData(webLog.getData());
        log.setMessage(webLog.getMessage());
        log.setLabel(webLog.getLabel());
        if (webLog.getError() != null) {
            log.setErrorName(webLog.getError().name());
            log.setErrorStack(webLog.getError().stack());
            log.setErrorMessage(webLog.getError().message());
        }
        return log;
    }

    public WebLog fromLog(Log log) {
        return new WebLog(
                log.getId().toString(),
                new Client(log.getClientVersion(), log.getClientRevision(), log.getClientName()),
                log.getData(),
                new Error(log.getErrorName(), log.getErrorMessage(), log.getErrorStack()),
                log.getLabel(),
                log.getMessage(),
                log.getTimestamp(),
                log.getUrl(),
                new User(log.getUserId(), log.getUserBrowser(), log.getUserLanguage()));
    }
}
