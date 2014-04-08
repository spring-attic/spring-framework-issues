package org.springframework.issues.spr11669;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.issues.spr11669.domain.model.Member;
import org.springframework.issues.spr11669.domain.repository.MemberRepository;
import org.springframework.issues.spr11669.domain.service.MemberService;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Stephane Nicoll
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReproTests.Config.class)
public class ReproTests {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Autowired
	private MemberService memberService;

	@Test
	public void duplicateKey() {
		Member member = new Member();
		member.setId("duplicateId");
		member.setName("foo bar");
		member.setEmail("info@bar.com");

		memberService.create(member);

		thrown.expect(DuplicateKeyException.class);
		memberService.create(member);
	}


	@Configuration
	@ComponentScan(basePackages = "org.springframework.issues.spr11669.domain")
	@EnableTransactionManagement
	@EnableJpaRepositories(basePackages = "org.springframework.issues.spr11669.domain.repository")
	public static class Config {

		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:mem:SPR-11669;DB_CLOSE_DELAY=-1;");
			dataSource.setDefaultAutoCommit(false);
			return dataSource;
		}

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
			LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
			factory.setDataSource(dataSource());
			factory.setPackagesToScan("org.springframework.issues.spr11669.domain.model");
			factory.setJpaVendorAdapter(jpaVendorAdapter());
			factory.setJpaProperties(jpaProperties());
			return factory;
		}

		@Bean
		public JpaTransactionManager transactionManager() {
			return new JpaTransactionManager(entityManagerFactory().getObject());
		}

		@Bean
		public DataSourceInitializer dataSourceInitializer() {
			DataSourceInitializer initializer = new DataSourceInitializer();
			initializer.setDataSource(dataSource());

			ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
			databasePopulator.setContinueOnError(true);
			databasePopulator.addScript(new ClassPathResource("database/ddl.sql"));
			databasePopulator.addScript(new ClassPathResource("database/dml.sql"));
			initializer.setDatabasePopulator(databasePopulator);
			return initializer;

		}

		private JpaVendorAdapter jpaVendorAdapter() {
			HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
			jpaVendorAdapter.setShowSql(false);
			jpaVendorAdapter.setDatabase(Database.H2);
			return jpaVendorAdapter;
		}

		private Properties jpaProperties() {
			Properties p = new Properties();
			p.put("hibernate.hbm2ddl.auto", "none");
			p.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
			p.put("hibernate.connection.charSet", "UTF-8");
			p.put("hibernate.show_sql", "false");
			p.put("hibernate.format_sql", "false");
			p.put("hibernate.use_sql_comments", "true");
			p.put("hibernate.jdbc.batch_size", "30");
			p.put("hibernate.jdbc.fetch_size", "100");
			return p;
		}

	}

}
