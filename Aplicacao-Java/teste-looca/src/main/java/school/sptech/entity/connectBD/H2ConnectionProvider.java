package school.sptech.entity.connectBD;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Classe responsável por gerenciar a conexão com o banco H2.
 * O banco é salvo localmente com o nome 'safeclass'.
 */
public class H2ConnectionProvider {

    private final JdbcTemplate jdbcTemplate;
    private final BasicDataSource basicDataSource;

    public H2ConnectionProvider() {
        basicDataSource = new BasicDataSource();

        // Caminho do banco local H2
        basicDataSource.setUrl("jdbc:h2:~/safeclass;AUTO_SERVER=TRUE");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        basicDataSource.setDriverClassName("org.h2.Driver");

        this.jdbcTemplate = new JdbcTemplate(basicDataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }
}
