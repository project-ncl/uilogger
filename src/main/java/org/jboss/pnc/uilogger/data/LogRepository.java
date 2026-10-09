package org.jboss.pnc.uilogger.data;

import java.util.List;

import org.jboss.pnc.uilogger.model.Order;

public interface LogRepository {

    public void save(Log log);

    public Log get(Long id);

    public List<Log> getAll(int page, int size, Order order);

}
