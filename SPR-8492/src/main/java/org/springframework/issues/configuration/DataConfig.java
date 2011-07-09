package org.springframework.issues.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

@PropertySource("classpath:org/springframework/issues/database.properties")
@Configuration
public class DataConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() throws Exception {
		return new AnnotationSessionFactoryBuilder()
				.setDataSource(dataSource())
				.setPackagesToScan("org.springframework.issues.domain")
				.buildSessionFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		return new HibernateTransactionManager(sessionFactory());
	}

}
