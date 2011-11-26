package org.springframework.issues;

import java.awt.Dimension;
import java.awt.Point;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ReproTests {

	@Test
	public void reproWithBeanUtils() throws SecurityException,
			NoSuchMethodException {
		BeanUtils.getPropertyDescriptor(Repro.class, "size");
		BeanUtils.getPropertyDescriptor(Repro.class, "location");
	}

	@Test
	public void reproSizeWithBeanUtils() throws SecurityException,
			NoSuchMethodException {
		PropertyDescriptor propertyDescriptor = BeanUtils
				.getPropertyDescriptor(Repro.class, "size");
		// I guess the following is the intended result although normal
		// Interpolation wouldn't yield to it.
		Assert.assertNotNull(propertyDescriptor);
		Assert
				.assertFalse((propertyDescriptor instanceof IndexedPropertyDescriptor));
		Assert.assertEquals(Dimension.class, propertyDescriptor
				.getPropertyType());
		Method readMethod = propertyDescriptor.getReadMethod();
		Assert.assertEquals(Repro.class.getMethod("getSize"), readMethod);
		Method writeMethod = propertyDescriptor.getWriteMethod();
		Assert.assertEquals(Repro.class.getMethod("setSize", Dimension.class),
				writeMethod);
	}

	@Test
	public void reproLocationeWithBeanUtils() throws SecurityException,
			NoSuchMethodException {
		PropertyDescriptor propertyDescriptor = BeanUtils
				.getPropertyDescriptor(Repro.class, "location");
		// I guess the following is the intended result although normal
		// Interpolation wouldn't yield to it.
		Assert.assertNotNull(propertyDescriptor);
		Assert
				.assertFalse((propertyDescriptor instanceof IndexedPropertyDescriptor));
		Assert.assertEquals(Point.class, propertyDescriptor.getPropertyType());
		Method readMethod = propertyDescriptor.getReadMethod();
		Assert.assertEquals(Repro.class.getMethod("getLocation"), readMethod);
		Method writeMethod = propertyDescriptor.getWriteMethod();
		Assert.assertEquals(Repro.class.getMethod("setLocation", Point.class),
				writeMethod);
	}

	@Test
	public void reproWithBeanWrapper() {
		BeanWrapper beanWrapper = new BeanWrapperImpl(Repro.class);
		PropertyDescriptor[] propertyDescriptors = beanWrapper
				.getPropertyDescriptors();
		Assert.assertNotNull(propertyDescriptors);
	}

	@Test
	public void reproWithApplicationContext() {
		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ReproConfig.class);
		Repro repro = applicationContext.getBean(Repro.class);
		Assert.assertNotNull(repro);
	}

	static class ReproConfig {
		@Bean
		public Repro repro() {
			return new Repro();
		}
	}
}
