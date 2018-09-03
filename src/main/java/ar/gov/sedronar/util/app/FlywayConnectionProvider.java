package ar.gov.sedronar.util.app;

/**
 * Created by TMR on 06/07/2018.
 */

import org.flywaydb.core.Flyway;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlywayConnectionProvider extends DatasourceConnectionProviderImpl {
    public static final Logger logger = Logger.getLogger("FlywayIntegrator");

    @Override
    public void configure(final Map props) {
        super.configure(props);

        logger.log(Level.INFO, "Starting Flyway Migration");

        final Flyway flyway = new Flyway();
        try {
            DataSource dataSource = InitialContext.doLookup("java:jboss/datasources/PicsDS");
            flyway.setDataSource(dataSource);
            flyway.setBaselineOnMigrate(true);
            flyway.setBaselineVersionAsString("0");
            flyway.setSchemas("suit");
            try {
                flyway.migrate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "Finished Flyway Migration");
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean isUnwrappableAs(final Class unwrapType) {
        return super.isUnwrappableAs(unwrapType) || FlywayConnectionProvider.class.isAssignableFrom(unwrapType);
    }
}