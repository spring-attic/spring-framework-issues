package org.springframework.issues;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Transactional("myTransactionManager")
public class ServiceWithTransactionalityImpl implements ServiceWithTransactionality {

    private final JdbcTemplate jdbcTemplate;

    public ServiceWithTransactionalityImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void doSomething() {
        this.jdbcTemplate.getMaxRows();
    }
}
