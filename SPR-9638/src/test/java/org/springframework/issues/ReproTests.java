package org.springframework.issues;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReproTests {

	@Test
	public void success() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.setConfigLocation("classpath:org/springframework/issues/config.xml");
		context.getEnvironment().setActiveProfiles("success");
		context.refresh();

		TestInitializingBean bean = context.getBean(TestInitializingBean.class);

		assertTrue(Proxy.isProxyClass(bean.getControllerType()));
	}

	@Test
	public void failure() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		context.setConfigLocation("classpath:org/springframework/issues/config.xml");
		context.getEnvironment().setActiveProfiles("failure");
		context.refresh();

		TestInitializingBean bean = context.getBean(TestInitializingBean.class);

		assertTrue(Proxy.isProxyClass(bean.getControllerType()));
	}

}
