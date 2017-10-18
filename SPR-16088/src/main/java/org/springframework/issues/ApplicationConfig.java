package org.springframework.issues;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * @author Greg Potter
 * @since 10/17/17
 */
@Configuration
public class ApplicationConfig {

    // Without JTA (uncomment this to see it "work")
    /*
    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Primary
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource datasource) throws Throwable {
        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
        localSessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        Properties hibernateProperties = new Properties();
        localSessionFactory.setHibernateProperties(hibernateProperties);
        localSessionFactory.setDataSource(datasource);
        return localSessionFactory;
    }
    */

    @Bean
    public LocalSessionFactoryBean sessionFactory(PlatformTransactionManager transactionManager,
                                                  DataSource datasource) throws Throwable {

        LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
        localSessionFactory.setJtaTransactionManager(transactionManager);
        localSessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.transaction.coordinator_class", "jta");
        localSessionFactory.setHibernateProperties(hibernateProperties);
        localSessionFactory.setDataSource(datasource);
        return localSessionFactory;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(new TransactionAwareDataSourceProxy(dataSource));
    }
}
