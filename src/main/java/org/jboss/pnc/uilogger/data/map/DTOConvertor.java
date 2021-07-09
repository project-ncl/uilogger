package org.jboss.pnc.uilogger.data.map;

import org.jboss.pnc.uilogger.data.Log;
import org.jboss.pnc.uilogger.model.WebLog;

public interface DTOConvertor {

    public Log toLog(WebLog webLog);

    public WebLog fromLog(Log log);

}
