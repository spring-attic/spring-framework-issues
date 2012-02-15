package org.mcp.test;

import junit.framework.Assert;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ActiveMQTest {

	@Test
	public void testJmsConnectionFactory() {
		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("test");
		applicationContext.load("/jmsContext.xml");
		applicationContext.refresh();
		String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
		Assert.assertTrue(ArrayUtils.contains(profiles, "test"));
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Assert.assertTrue(ArrayUtils.contains(beanNames, "jmsConnectionFactory"));
	}

}
