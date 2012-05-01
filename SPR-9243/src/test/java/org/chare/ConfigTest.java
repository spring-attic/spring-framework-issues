package org.chare;

import org.chare.service.Service;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.Assert.*;

public class ConfigTest {

	@Test
	public void testConfig() throws Exception {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		assertNotNull(context.getBean(Service.class));
		context.close();
	}

}
