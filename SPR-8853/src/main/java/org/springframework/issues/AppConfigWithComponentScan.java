package org.springframework.issues;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "org.springframework.issues", excludeFilters = {@ComponentScan.Filter(Configuration.class)})
@ImportResource({"classpath*:properties-config.xml"})
public class AppConfigWithComponentScan
{
    @Bean
    public SessionFactory sessionFactory() throws Exception
    {
        AnnotationSessionFactoryBean bean = new AnnotationSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan(new String[] {"org.springframework.issues"});
        bean.setHibernateProperties(hibernateProps());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Properties hibernateProps()
    {
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
        jpaProperties.put("hibernate.show_sql", false);
        jpaProperties.put("hibernate.format_sql", true);
        return jpaProperties;
    }

    @Value("${db.driverClass}") private String driverClass;
    @Value("${db.jdbcUrl}") private String jdbcUrl;
    @Value("${db.user}") private String user;
    @Value("${db.password}") private String password;

    @Bean
    public DataSource dataSource()
    {
        return new DriverManagerDataSource(driverClass, jdbcUrl, user, password);
    }
}
