package org.springframework.issues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.issues.ReproTests.Bad.Bar;
import org.springframework.stereotype.Component;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	private AnnotationConfigApplicationContext ctx;

	@Test
	public void bad() {
		ctx = new AnnotationConfigApplicationContext(Bad.class);
		BeanDefinition definition = ctx.getBeanDefinition(ctx.getBeanNamesForType(Bar.class)[0]);
		assertEquals("test", definition.getScope());
	}

	@Test
	public void good() {
		ctx = new AnnotationConfigApplicationContext(Good.class);
		BeanDefinition definition = ctx.getBeanDefinition(ctx.getBeanNamesForType(Bar.class)[0]);
		assertEquals("test", definition.getScope());
	}

	@Test
	public void ok() {
		ctx = new AnnotationConfigApplicationContext(Ok.class, Bar.class);
		BeanDefinition definition = ctx.getBeanDefinition(ctx.getBeanNamesForType(Bar.class)[0]);
		assertEquals("test", definition.getScope());
	}

	@Test
	public void questionable() {
		ctx = new AnnotationConfigApplicationContext(Questionable.class);
		BeanDefinition definition = ctx.getBeanDefinition(ctx.getBeanNamesForType(Bar.class)[0]);
		assertEquals("test", definition.getScope());
	}

	@Configuration
	protected static class Questionable {

		@Bean
		public Bar bar() {
			return new Bar();
		}

		@Bean
		public static TestScope testScope() {
			return new TestScope();
		}

	}

	@Configuration
	protected static class Ok {

		@Bean
		public static TestScope testScope() {
			return new TestScope();
		}

	}

	@Configuration
	protected static class Good {

		@Bean
		@Scope("test")
		public Bar bar() {
			return new Bar();
		}

		@Bean
		public static TestScope testScope() {
			return new TestScope();
		}

	}

	@Configuration
	protected static class Bad {

		@Component
		@Scope("test")
		protected static class Bar {

		}

	}

	@Component
	protected static class TestScope implements org.springframework.beans.factory.config.Scope,
			BeanFactoryPostProcessor {

		@Override
		public Object get(String name, ObjectFactory<?> factory) {
			return factory.getObject();
		}

		@Override
		public String getConversationId() {
			return null;
		}

		@Override
		public void registerDestructionCallback(String name, Runnable callback) {
		}

		@Override
		public Object remove(String name) {
			return null;
		}

		@Override
		public Object resolveContextualObject(String arg0) {
			return null;
		}

		@Override
		public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
			beanFactory.registerScope("test", this);
		}

	}

}
