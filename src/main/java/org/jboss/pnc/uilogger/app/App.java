package org.jboss.pnc.uilogger.app;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class App {
    void onStart(@Observes StartupEvent ev) {
        log.info(
                "App uilogger is starting: {}, will connect to db: {}",
                AppInfo.getAppInfoString(),
                System.getenv("POSTGRESQL_URL"));
    }
}
