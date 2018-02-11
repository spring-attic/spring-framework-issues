package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.time.LocalDateTime;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    private DataSource dataSource;

    @Before
    public void setup() {
        this.dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Test // This is work fine.
    public void fetchLocalDateTimeViaBean() {
        LocalDateTime now = LocalDateTime.now();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Bean bean = jdbcTemplate.queryForObject(
                "SELECT current_timestamp as localDateTime FROM INFORMATION_SCHEMA.SYSTEM_USERS",
                new BeanPropertyRowMapper<>(Bean.class));
        assertTrue(bean.getLocalDateTime().isEqual(now) || bean.getLocalDateTime().isAfter(now));
    }

    @Test // This is not work fine. -> TypeMismatchDataAccessException
    public void fetchLocalDateTimeViaReturnType() {
        LocalDateTime now = LocalDateTime.now();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LocalDateTime localDateTime = jdbcTemplate.queryForObject(
                "SELECT current_timestamp FROM INFORMATION_SCHEMA.SYSTEM_USERS"
                , LocalDateTime.class);
        assertTrue(localDateTime.isEqual(now) || localDateTime.isAfter(now));
    }

    private static class Bean {
        private LocalDateTime localDateTime;

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public void setLocalDateTime(LocalDateTime localDateTime) {
            this.localDateTime = localDateTime;
        }
    }

}
