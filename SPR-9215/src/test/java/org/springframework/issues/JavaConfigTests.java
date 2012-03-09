package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.issues.datamodel.TestData;
import org.springframework.issues.service.TestService;

public class JavaConfigTests {

	@Test
	public void javaConfigurationTest() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				AppConfig.class);
		try {
			TestService ts = ctx.getBean(TestService.class);

			TestData entity = new TestData();
			entity.setName("This is a test.");
			entity = ts.saveTestData(entity);
			Long id = entity.getId();
			TestData e1 = ts.loadTestDataById(id);
			assertNotNull(e1);
			assertEquals("This is a test.", e1.getName());
		} finally {
			ctx.close();
		}
	}
}
