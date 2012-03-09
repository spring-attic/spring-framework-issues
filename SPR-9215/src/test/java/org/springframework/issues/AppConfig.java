package org.springframework.issues;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.cache.HashtableCacheProvider;
import org.hibernate.dialect.HSQLDialect;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

@Configuration
@ComponentScan("org.springframework.issues")
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, order = 0)
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@PropertySource("/config.properties")
public class AppConfig {
	@Resource
	private Environment env;

	@Bean
	public Map<String, Object> jpaProperties() {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.dialect", HSQLDialect.class.getName());
		props.put("hibernate.cache.provider_class",
				HashtableCacheProvider.class.getName());
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lcemfb.setJpaDialect(jpaDialect());
		lcemfb.setPersistenceUnitName("default");
		lcemfb.setPersistenceUnitManager(persistenceUnitManager());
		lcemfb.setJpaPropertyMap(jpaProperties());
		lcemfb.setDataSource(dataSource());
		return lcemfb;
	}

	@Bean
	public PersistenceUnitManager persistenceUnitManager() {
		DefaultPersistenceUnitManager dpum = new DefaultPersistenceUnitManager();
		dpum.setDefaultDataSource(dataSource());
		return dpum;
	}

	@Bean
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	public AnnotationTransactionAspect annotationTransactionAspect() {
		AnnotationTransactionAspect ata = AnnotationTransactionAspect
				.aspectOf();
		ata.setTransactionManager(txManager());
		return ata;
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClass"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setInitialSize(1);
		ds.setMinIdle(1);
		ds.setMaxIdle(1);
		ds.setMaxActive(2);
		ds.setMaxWait(5000);
		return ds;
	}

	@Bean
	public PlatformTransactionManager txManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		txManager.setDataSource(dataSource());
		return txManager;
	}
}
