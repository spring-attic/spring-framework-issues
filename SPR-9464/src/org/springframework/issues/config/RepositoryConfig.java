package org.springframework.issues.config;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class RepositoryConfig {

	private static final Logger logger = LoggerFactory.getLogger(RepositoryConfig.class);
	private EmbeddedDatabase db;

	@Bean(name = "dataSource")
	DataSource dataSource() {
		logger.info("Setting up database");

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).
				addScript("schema.sql").
				addScript("test-data.sql").build();

		this.db = db;

		return db;
	}

	@PreDestroy
	void destroy() {
		logger.info("Shutting down database");

		this.db.shutdown();
	}
}
