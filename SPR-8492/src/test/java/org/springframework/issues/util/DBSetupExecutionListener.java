package org.springframework.issues.util;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.h2.tools.RunScript;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class DBSetupExecutionListener extends AbstractTestExecutionListener {

	private static Logger LOG = Logger
			.getLogger(DBSetupExecutionListener.class);

	private Connection conn;

	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
		if (LOG.isDebugEnabled())
			LOG.debug("starting beforeTestClass");
		// startup H2 DB
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
		Resource resource = new ClassPathResource(
				"org/springframework/issues/data/createDB.ddl.sql");
		RunScript.execute(conn,
				new InputStreamReader(resource.getInputStream()));
		resource = new ClassPathResource(
				"org/springframework/issues/data/initDB.sql");
		RunScript.execute(conn,
				new InputStreamReader(resource.getInputStream()));
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		conn.close();
	}
}
