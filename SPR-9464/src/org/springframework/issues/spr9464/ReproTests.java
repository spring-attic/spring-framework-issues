package org.springframework.issues.spr9464;

import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.issues.service.TestService;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class ReproTests {

	@Test
	public void javaCentric() {

		GenericApplicationContext appContext = new AnnotationConfigApplicationContext(
				org.springframework.issues.config.java_centric.AppConfig.class);

		TestService service = appContext.getBean(TestService.class);
		assertThat(service.queryDummyValue(), equalTo(12345));
		appContext.close();
	}

	@Test
	public void xmlCentric() {

		GenericApplicationContext appContext = new GenericXmlApplicationContext(
				"classpath:org/springframework/issues/config/xml_centric/app-config.xml");

		TestService service = appContext.getBean(TestService.class);
		assertThat(service.queryDummyValue(), equalTo(12345));
		appContext.close();
	}
}
