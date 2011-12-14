package org.test.profile;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ExampleConfigurationTests {

	@After
	public void cleanup() {
		System.clearProperty("spring.profiles.active");
	}

	@Test
	public void testRootContextWithJdbcUsers() throws Exception {
		System.setProperty("spring.profiles.active", "jdbc");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(new ClassPathResource(getClass()
				.getSimpleName() + "-context.xml", getClass()));
		@SuppressWarnings("unchecked")
		Map<String, String> value = context.getBean("value", Map.class);
		assertEquals("{platform.foo=bar}", value.toString());
		context.close();
	}
}
