package org.springframework.issues;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Autowired

	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ReproConfiguration.class);
		ctx.getBean(NonDisposableBean.class);
		ctx.getBean(DisposableBean.class);

		Map<String, Object> factoryBeanObjectCache = (Map<String, Object>) ReflectionTestUtils.getField(ctx.getBeanFactory(), "factoryBeanObjectCache");
		assertEquals(2, factoryBeanObjectCache.size());

		ctx.close();

		// Should be empty after closing the context.
		assertTrue(factoryBeanObjectCache.isEmpty());
	}

	@Configuration
	public static class ReproConfiguration {

		@Bean
		public DisposableBeanCreatingFactoryBean disposableBeanCreatingFactoryBean() {
			return new DisposableBeanCreatingFactoryBean();
		}

		@Bean
		public NonDisposableBeanCreatingFactoryBean nonDisposableBeanCreatingFactoryBean() {
			return new NonDisposableBeanCreatingFactoryBean();
		}

	}

}
