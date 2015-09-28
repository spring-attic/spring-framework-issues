package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.issues.datamodel.TestData;
import org.springframework.issues.service.TestService;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods
 * within need not pass with the green bar! Rather they should fail in such a
 * way that demonstrates the reported issue.
 */
public class XmlConfigTests {

	@Test
	public void xmlConfigurationTest() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:/org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();
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
