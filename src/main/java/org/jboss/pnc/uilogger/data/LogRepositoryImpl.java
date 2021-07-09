package org.jboss.pnc.uilogger.data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<Log> getAll() {
        List<Log> logs = em.createQuery("from Log", Log.class).getResultList();
        return logs;
    }
}
