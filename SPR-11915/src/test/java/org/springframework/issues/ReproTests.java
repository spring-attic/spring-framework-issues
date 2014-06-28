package org.springframework.issues;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReproTests.TestConfig.class,
        initializers = AppInitializer.class)
public class ReproTests {

    @Autowired
    private ServiceWithTransactionality testObject;

    @Test
    public void test_something() throws Exception {
        testObject.doSomething();
    }

    @Configuration
    @EnableTransactionManagement
    static class TestConfig {

        @Autowired
        public DataSource dataSource;

        @Bean
        public ServiceWithTransactionality serviceWithTransactionality() {
            return new ServiceWithTransactionalityImpl(dataSource);
        }


    }

}
