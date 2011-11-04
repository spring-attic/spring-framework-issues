package org.springframework.issues;

import static org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void testPlainObjectSucess() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Baz.class);
		ctx.refresh();

		Baz bean = ctx.getBean(Baz.class);
		Assert.assertEquals(bean.getClass(), Baz.class);
		Assert.assertEquals(1, bean.getValueCounter());
		ctx.getBeanFactory().autowireBeanProperties(unwrapAopProxyIfNecessary(bean), AUTOWIRE_BY_NAME, false);
		Assert.assertEquals(2, bean.getValueCounter());
	}

	@Test
	public void testJdkProxyObjectFail() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BarImpl.class, APC_Config.class);
		ctx.refresh();

		Bar bean = ctx.getBean(Bar.class);
		Assert.assertTrue(AopUtils.isJdkDynamicProxy(bean));
		Assert.assertEquals(1, bean.getValueCounter());
		ctx.getBeanFactory().autowireBeanProperties(unwrapAopProxyIfNecessary(bean), AUTOWIRE_BY_NAME, false);
		Assert.assertEquals(2, bean.getValueCounter());
	}

	@Test
	public void testCglibProxyObjectFail() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Foo.class, APC_Config.class);
		ctx.refresh();

		Foo bean = ctx.getBean(Foo.class);
		Assert.assertTrue(AopUtils.isCglibProxy( bean ));
		Assert.assertEquals(1, bean.getValueCounter());
		ctx.getBeanFactory().autowireBeanProperties(unwrapAopProxyIfNecessary(bean), AUTOWIRE_BY_NAME, false);
		Assert.assertEquals(2, bean.getValueCounter());
	}

	@Configuration
	static class APC_Config {
		@Bean
		public BeanNameAutoProxyCreator apc() {
			BeanNameAutoProxyCreator apc = new BeanNameAutoProxyCreator();
			apc.setBeanNames(new String[] { "foo", "bar" });
			return apc;
		}
	}

	private static Object unwrapAopProxyIfNecessary(Object bean) {
		if (AopUtils.isAopProxy(bean)) {
			try {
				return ((Advised)bean).getTargetSource().getTarget();
			} catch (Exception ex) {
				throw new IllegalStateException("AOP proxy target cannot be resolved", ex);
			}
		}
		return bean;
	}
}
