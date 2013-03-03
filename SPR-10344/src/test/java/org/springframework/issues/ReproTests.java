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
		System.setProperty("foo", "local");
	}

	@Test
	public void localPropertyPlaceholderOverrideFalse() {
		localPropertiesOverride(false, "classpath:org/springframework/issues/PropertyPlaceholderConfigurerFalse-context.xml");
	}

	@Test
	public void localPropertySourcesPlaceholderOverrideFalse() {
		localPropertiesOverride(false, "classpath:org/springframework/issues/PropertySourcesPlaceholderConfigurerFalse-context.xml");
	}

	@Test
	public void localPropertyPlaceholderOverrideTrue() {
		localPropertiesOverride(true, "classpath:org/springframework/issues/PropertyPlaceholderConfigurerTrue-context.xml");
	}

	@Test
	public void localPropertySourcesPlaceholderOverrideTrue() {
		localPropertiesOverride(true, "classpath:org/springframework/issues/PropertySourcesPlaceholderConfigurerTrue-context.xml");
	}

	public void localPropertiesOverride(boolean override, String resourceLocation) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load(resourceLocation);
		ctx.refresh();

		assertThat(System.getProperty("foo"), equalTo("local"));

		if (override) {
			assertThat(ctx.getBean(TestBean.class).getName(), equalTo("local"));
		}
		else {
			assertThat(ctx.getBean(TestBean.class).getName(), equalTo("enclosing"));
		}

		ctx.close();
	}

}
