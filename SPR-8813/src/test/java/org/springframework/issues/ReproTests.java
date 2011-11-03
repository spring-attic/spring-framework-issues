package org.springframework.issues;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Configuration
	static class PPCConfig {
		@Bean
		public static PropertyPlaceholderConfigurer ppc() {
			PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
			Properties props = new Properties();
			props.setProperty("issues.test", "whatev");
			ppc.setProperties(props);
			return ppc;
		}
	}

	@Test
	public void testPlainObjectSucess() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Config1.class);
		ctx.refresh();
		
		Baz bean = ctx.getBean(Baz.class);

		Assert.assertEquals(bean.getClass(), Baz.class);
		Assert.assertEquals(1, bean.getValueCounter());

		ctx.getBeanFactory().autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);

		Assert.assertEquals(2, bean.getValueCounter());
	}

	@Configuration
	static class Config1 extends PPCConfig {
		@Bean
		public Baz baz() {
			return new Baz();
		}
	}

	@Test
	public void testJdkProxyObjectFail() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Config2.class);
		ctx.refresh();

		Bar bean = ctx.getBean(Bar.class);

		Assert.assertEquals(1, bean.getValueCounter());
		Assert.assertFalse( ClassUtils.isCglibProxy( bean ) );

		ctx.getBeanFactory().autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);

		Assert.assertEquals(2, bean.getValueCounter());

	}
	@Configuration
	static class Config2 extends PPCConfig {
		@Bean
		public Bar bar() {
			return new BarImpl();
		}
		@Bean
		public BeanNameAutoProxyCreator apc() {
			BeanNameAutoProxyCreator apc = new BeanNameAutoProxyCreator();
			apc.setBeanNames(new String[] { "bar" });
			return apc;
		}
	}

	@Test
	public void testCglibProxyObjectFail() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Config3.class);
		ctx.refresh();

		Foo bean = ctx.getBean(Foo.class);

		Assert.assertEquals(1, bean.getValueCounter());
		Assert.assertTrue( ClassUtils.isCglibProxy( bean ) );

		ctx.getBeanFactory().autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);

		Assert.assertEquals(2, bean.getValueCounter());
	}
	@Configuration
	static class Config3 extends PPCConfig {
		@Bean
		public Foo foo() {
			return new Foo();
		}
		@Bean
		public BeanNameAutoProxyCreator apc() {
			BeanNameAutoProxyCreator apc = new BeanNameAutoProxyCreator();
			apc.setBeanNames(new String[] { "foo" });
			return apc;
		}
	}

}
