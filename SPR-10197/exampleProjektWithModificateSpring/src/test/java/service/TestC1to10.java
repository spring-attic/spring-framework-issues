package service;


import junit.framework.Assert;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.C;
import service.C1;
import service.C2;
import service.C3;
import service.C4;
import service.C5;
import service.C6;
import service.C7;
import service.Service;

public class TestC1to10 {

	
	@Test
	public void test1(){
		
		long time = System.currentTimeMillis();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(C1.class,C2.class,C3.class,C4.class,C5.class,C6.class,C7.class);
		Service service4 = (Service) applicationContext.getBean("service04");
		Assert.assertNotNull(service4);
		
		System.out.println(System.currentTimeMillis() - time);
	}
	
	
}
