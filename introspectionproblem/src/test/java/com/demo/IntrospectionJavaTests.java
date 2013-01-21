package com.demo;

import org.codehaus.groovy.grails.commons.spring.GrailsWebApplicationContext;
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;

public class IntrospectionJavaTests {
	@Test
	public void testSomething() {
		Object ctx = new GrailsWebApplicationContext();
		BeanWrapperImpl wrapper = new BeanWrapperImpl(ctx);
		assert wrapper.isReadableProperty("autowireCapableBeanFactory");
	}
	
	public static GrailsWebRequest getMessageSource() {
        return null;
	}
}

