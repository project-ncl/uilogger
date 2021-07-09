package org.jboss.pnc.uilogger.data;

import java.util.List;

public interface LogRepository {

    public void save(Log log);

    public Log get(Long id);

    public List<Log> getAll();

}
