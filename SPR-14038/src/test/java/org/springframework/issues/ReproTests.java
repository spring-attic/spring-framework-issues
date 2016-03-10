package org.springframework.issues;

import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    @Test
    public void jdbc() throws InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataSourceContext.class)) {
            TransactionalService service = ctx.getBean(TransactionalService.class);
            {
                service.execute("jdbc1", 0, 0); // OK
            }
            {
                try {
                    service.execute("jdbc2", 2, 0); // OK
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
            {
                try {
                    service.execute("jdbc3", 0, 2); // NG
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }

        }
    }


    @Test
    public void jpa() throws InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaContext.class)) {
            TransactionalService service = ctx.getBean(TransactionalService.class);
            {
                service.execute("jpa1", 0, 0); // OK
            }
            {
                try {
                    service.execute("jpa2", 3, 0); // OK
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
            {
                try {
                    service.execute("jpa3", 0, 3); // NG
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }

        }
    }

    @Test
    public void jta() throws InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JtaDataSourceContext.class)) {
            TransactionalService service = ctx.getBean(TransactionalService.class);
            {
                service.execute("jta1", 0, 0); // OK
            }
            {
                try {
                    service.execute("jta2", 3, 0); // OK
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
            {
                try {
                    service.execute("jta3", 0, 3); // OK
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
        }
    }


    @Test
    public void jms() throws InterruptedException {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JmsContext.class)) {
            TransactionalService service = ctx.getBean(TransactionalService.class);
            {
                service.execute("jms1", 0, 0); // OK
            }
            {
                try {
                    service.execute("jms2", 3, 0); // NG
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
            {
                try {
                    service.execute("jms3", 0, 3); // NG
                    Assert.fail("This case should be aborted transaction");
                } catch (TransactionException e) {
                    // NO-OP
                }
            }
        }
    }

    @EnableTransactionManagement
    @Configuration
    static class DataSourceContext {
        @Bean
        DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        }

        @Bean
        DataSourceTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }

        @Bean
        TransactionalService service() {
            return new TransactionalService((msg) -> System.out.println(jdbcTemplate().queryForObject("SELECT " + "'" + msg + "'", String.class)));
        }

    }


    @EnableTransactionManagement
    @Configuration
    static class JpaContext {

        @PersistenceContext
        EntityManager entityManager;

        @Bean
        DataSource dataSource() {
            return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        }

        @Bean
        EntityManagerFactory entityManagerFactory() {
            HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
            adapter.setDatabase(Database.H2);
            adapter.setGenerateDdl(true);
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setJpaVendorAdapter(adapter);
            factoryBean.setPackagesToScan("org.springframework.issues");
            factoryBean.afterPropertiesSet();
            return factoryBean.getObject();
        }

        @Bean
        JpaTransactionManager transactionManager() {
            return new JpaTransactionManager(entityManagerFactory());
        }

        @Bean
        TransactionalService service() {
            return new TransactionalService((msg) -> System.out.println(entityManager.createQuery("SELECT x FROM ReproTests$Todo x WHERE x.id = 1", Todo.class).getResultList()));
        }

    }

    @EnableTransactionManagement
    @Configuration
    static class JtaDataSourceContext {

        @Bean(initMethod = "init", destroyMethod = "close")
        DataSource dataSource() {
            AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
            dataSource.setXaDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
            dataSource.setUniqueResourceName("dataSourceResource");
            Properties props = new Properties();
            props.setProperty("user", "sa");
            props.setProperty("password", "");
            props.setProperty("url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
            dataSource.setXaProperties(props);
            return dataSource;
        }

        @Bean
        JtaTransactionManager transactionManager() {
            JtaTransactionManager transactionManager = new JtaTransactionManager();
            transactionManager.setTransactionManager(userTransactionManager());

            return transactionManager;
        }

        @Bean(initMethod = "init", destroyMethod = "close")
        UserTransactionManager userTransactionManager() {
            UserTransactionManager transactionManager = new UserTransactionManager();
            transactionManager.setForceShutdown(false);
            return transactionManager;
        }


        @Bean
        JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }

        @Bean
        TransactionalService service() {
            return new TransactionalService((msg) -> System.out.println(jdbcTemplate().queryForObject("SELECT " + "'" + msg + "'", String.class)));
        }

    }

    @EnableJms
    @EnableTransactionManagement
    @Configuration
    static class JmsContext {

        @Bean
        BrokerService brokerService() {
            return new BrokerService();
        }

        @Bean
        ActiveMQConnectionFactory connectionFactory() {
            return new ActiveMQConnectionFactory("vm://localhost");
        }

        @Bean
        JmsTransactionManager transactionManager() {
            return new JmsTransactionManager(connectionFactory());
        }

        @Bean
        JmsTemplate jmsTemplate() {
            return new JmsTemplate(connectionFactory());
        }

        @Bean
        public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
            DefaultJmsListenerContainerFactory factory =
                    new DefaultJmsListenerContainerFactory();
            factory.setConnectionFactory(connectionFactory());
            return factory;
        }


        @Bean
        TransactionalService service() {
            return new TransactionalService((msg) -> jmsTemplate().send("testQueue", (s) -> s.createTextMessage(msg)));
        }

    }

    @Transactional(timeout = 2)
    @Service
    static class TransactionalService {

        private final Consumer<String> consumer;

        public TransactionalService(Consumer<String> consumer) {
            this.consumer = consumer;
        }

        public void execute(String msg, int beforeWaitSec, int afterWaitSec) throws InterruptedException {
            TimeUnit.SECONDS.sleep(beforeWaitSec);
            consumer.accept(msg);
            TimeUnit.SECONDS.sleep(afterWaitSec);
        }

        @JmsListener(destination = "testQueue")
        public void print(String msg) {
            System.out.println(msg);
        }

    }

    @Entity
    static class Todo {
        @Id
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
