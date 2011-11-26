package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComponentScanTest {

	/** Tests that the dependency is injected into the abstract base class. */
	@Test
	public void testDependencyInjected() {
		ApplicationContext ctx = new GenericXmlApplicationContext("/applicationContext.xml");
		UsesAnnotation underTest = ctx.getBean(UsesAnnotation.class);
		assertNotNull(underTest);
	}

}
