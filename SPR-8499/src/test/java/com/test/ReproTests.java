package com.test;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ReproTests {

	@Test
	public void repro() {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("context.xml");
		MyReciever bean = context.getBean(MyReciever.class);
		bean.callMethod();
	}

}
