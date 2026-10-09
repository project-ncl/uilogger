package org.jboss.pnc.uilogger.data;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.jboss.pnc.uilogger.model.Order;

@RequestScoped
public class LogRepositoryImpl implements LogRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public void save(Log log) {
        em.persist(log);
    }

    @Override
    public Log get(Long id) {
        return null;
    }

    @Override
    public List<Log> getAll(int page, int size, Order order) {
        List<Log> logs = em.createQuery("from Log l order by l.id " + order, Log.class)
                .setFirstResult(page * size)
                .setMaxResults(size)
                .getResultList();
        return logs;
    }
}
