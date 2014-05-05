package org.springframework.issues.config;
//package com.springtest.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.core.env.Environment;
//import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
//import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import bitronix.tm.BitronixTransactionManager;
//import bitronix.tm.TransactionManagerServices;
//import bitronix.tm.resource.jdbc.PoolingDataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class PersistenceConfig {
//	
//	@Autowired
//	private Environment env;
//
//	@Value("${init-db:false}")
//	private String initDatabase;
//
//	
//	@Bean
//	public bitronix.tm.Configuration bitronixConfig() {
//		bitronix.tm.Configuration configuration = TransactionManagerServices.getConfiguration();
////		configuration.setJournal("null");
////		configuration.setServerId("spring-btm");
////		configuration.setDefaultTransactionTimeout(600);
////		configuration.setWarnAboutZeroResourceTransaction(false);
//
//		return configuration;
//	}
//
//	@Bean(destroyMethod="shutdown")
//	@DependsOn("bitronixConfig")
//	public BitronixTransactionManager bitronixTransactionManager() {
//		return TransactionManagerServices.getTransactionManager();
//	}
//	
//	@Bean
//	public JtaTransactionManager TransactionManagerServices() {
//		JtaTransactionManager transactionManager = new JtaTransactionManager();
//		transactionManager.setTransactionManager(bitronixTransactionManager());
//		
//		return transactionManager;
//	}
//	
//	@Bean(name="defaultPU")
//	@DependsOn("dataSource")
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		
//		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(Boolean.TRUE);
//		vendorAdapter.setShowSql(Boolean.TRUE);
//		vendorAdapter.setDatabase(Database.MYSQL);
//		
//		factory.setDataSource(dataSource());
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.springtest.data");
//		
//		Properties jpaProperties = new Properties();
//		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//		jpaProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
//		jpaProperties.put("hibernate.ejb.entitymanager_factory_name", env.getProperty("hibernate.dialect"));
//
//		jpaProperties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");
//		jpaProperties.put("hibernate.transaction.manager_lookup_class", "org.hibernate.transaction.BTMTransactionManagerLookup");
//		
//		factory.setJpaProperties(jpaProperties);
//		factory.setPersistenceUnitName("default");
//		factory.afterPropertiesSet();
//		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//		return factory;
//	}
//
//	@Bean
//	public HibernateExceptionTranslator hibernateExceptionTranslator() {
//		return new HibernateExceptionTranslator();
//	}
//
//	@Bean
//	public DataSource dataSource() {
//		PoolingDataSource dataSource = new PoolingDataSource();
//		Properties driverProperties = new Properties();
//		driverProperties.put("driverClassName", env.getProperty("jdbc.driverClassName"));
//		driverProperties.put("url", env.getProperty("jdbc.url"));
//		driverProperties.put("user", env.getProperty("jdbc.username"));
//		driverProperties.put("password", env.getProperty("jdbc.password"));
//		
//		dataSource.setClassName("bitronix.tm.resource.jdbc.lrc.LrcXADataSource");
//		dataSource.setUniqueName("defaultDataSource");
//		dataSource.setDriverProperties(driverProperties);
//		dataSource.setMinPoolSize(5);
//		dataSource.setMaxPoolSize(100);
//		dataSource.setUseTmJoin(true);
//		dataSource.setIsolationLevel("READ_COMMITTED");
//		
//		return dataSource;
//	}
//
//
////	@Bean
////	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
////		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
////		dataSourceInitializer.setDataSource(dataSource);
////		
////		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
////		databasePopulator.addScript(new ClassPathResource("db.sql"));
////		dataSourceInitializer.setDatabasePopulator(databasePopulator);
////		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
////		return dataSourceInitializer;
////	}
//}