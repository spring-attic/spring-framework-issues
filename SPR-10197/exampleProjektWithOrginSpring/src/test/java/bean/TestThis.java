package bean;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.Config;
import configuration.Config2;
import configuration.DIConfig;

import beans.Service4;


public class TestThis {

	@Test
	public void testTheContext(){
		
		long time = System.currentTimeMillis();
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class, Config2.class, DIConfig.class);
		Service4 service4 = (Service4) applicationContext.getBean("service4");
		Assert.assertNotNull(service4);
		
		System.out.println(System.currentTimeMillis() - time);
	}
}
