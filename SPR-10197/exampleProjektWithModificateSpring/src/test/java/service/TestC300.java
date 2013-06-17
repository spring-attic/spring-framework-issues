package service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.C300;
import service.Service;

public class TestC300 {

	
	@Test
	public void test1(){
		
		long time = System.currentTimeMillis();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(C300.class);
		Service service4 = (Service) applicationContext.getBean("service04");
		Assert.assertNotNull(service4);
		
		System.out.println(System.currentTimeMillis() - time);
	}
	
	
	
}
