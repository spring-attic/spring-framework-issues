package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectionTest {

	protected Target createTarget() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/context.xml");
		return context.getBean(Target.class);
	}

	@Test
	public void testResource() {
		Target t = createTarget();
		Assert.assertTrue(t.isResourceInjected());
	}

	@Test
	public void testAutowired() {
		Target t = createTarget();
		Assert.assertTrue(t.isAutowiredInjected());
	}

}
