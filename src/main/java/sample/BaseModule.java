package sample;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;

public class BaseModule implements SmartLifecycle {

    private @Autowired DataSource dataSource;

    private final String schemaName;
    private final int phase;

    protected BaseModule(String schemaName, int phase) {
        this.schemaName = schemaName;
        this.phase = phase;
    }

    @Override
    public void start() {
        final Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("db.migration." + schemaName);
        flyway.setSchemas(schemaName);
        flyway.migrate();
    }

    @Override
    public void stop() {}

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return phase;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {}

}
