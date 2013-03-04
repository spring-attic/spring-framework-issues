package org.springframework.issues;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.tests.sample.beans.TestBean;

/**
 * This test demonstrates how the Spring 3.1
 * PropertySourcesPlaceholderConfigurer treats the local-override property
 * differently than the PropertyPlaceholderConfigurer.
 * 
 * This test uses two application contexts that are identical except for the
 * Spring schema locations (PropertyPlaceholderConfigurer-context.xml uses
 * *-3.0.xml whereas PropertySourcesPlaceholderConfigurer-context.xml uses
 * *-3.2.xml).
 * 
 * @author Patrick Crocker <patrick.crocker@gmail.com>
 * 
 */
public class ReproTests {

	@BeforeClass
	public static void setUpBeforeClass() {
		System.setProperty("k1", "v1-system");
	}

	@Test
	public void propertyPlaceholderWithLocalOverrideFalse() {
		assertThat(v1("classpath:org/springframework/issues/PropertyPlaceholderConfigurerFalse-context.xml"), equalTo("v1-local"));
	}

	@Test
	public void propertyPlaceholderWithLocalOverrideFalseAndSystemPropertiesModeOverride() {
		assertThat(v1("classpath:org/springframework/issues/PropertyPlaceholderConfigurerFalse-SPMOverride-context.xml"), equalTo("v1-system"));
	}

	@Test
	public void propertySourcesPlaceholderWithLocalOverrideFalse() {
		assertThat(v1("classpath:org/springframework/issues/PropertySourcesPlaceholderConfigurerFalse-context.xml"), equalTo("v1-system"));
	}

	@Test
	public void propertyPlaceholderWithLocalOverrideTrue() {
		assertThat(v1("classpath:org/springframework/issues/PropertyPlaceholderConfigurerTrue-context.xml"), equalTo("v1-local"));
	}

	@Test
	public void propertySourcesPlaceholderWithLocalOverrideTrue() {
		assertThat(v1("classpath:org/springframework/issues/PropertySourcesPlaceholderConfigurerTrue-context.xml"), equalTo("v1-local"));
	}

	public String v1(String resourceLocation) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load(resourceLocation);
		ctx.refresh();

		try {
			return ctx.getBean(TestBean.class).getName();
		}
		finally {
			ctx.close();
		}
	}

}
