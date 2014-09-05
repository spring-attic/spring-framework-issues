package org.springframework.issues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.math.BigInteger;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@ContextConfiguration(classes = ReproTests.Config.class)
public class ReproTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Before
    public void setUp() throws Exception {
        super.jdbcTemplate.execute("CREATE TABLE emp(name VARCHAR(100), salary INTEGER)");
        super.jdbcTemplate.execute("INSERT INTO emp VALUES('Joe',20000),('Martin',25000),('Murphy',30000),('Sophie',18000),('Brett',22000),('Joel',31000)");
    }

    @Test
    public void repro() {
        Assert.assertEquals(0, jdbcTemplate.queryForObject("SELECT CAST (max(salary) AS BIGINT) FROM emp", BigInteger.class).compareTo(BigInteger.valueOf(31000l)));
    }

    @Configuration
    static class Config {

        @Bean
        public DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

    }

}
