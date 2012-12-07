package org.springframework.issues;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.annotation.ProxyCachingConfiguration;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.NoOpCacheManager;
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
	public void works() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class, TestConfiguration.class);
		assertNotNull(context.getBean("myBean"));
		context.close();
	}

	@Test
	public void fails() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TestConfiguration.class);
		assertNotNull(context.getBean("myBean"));
		context.close();
	}

	@Test
	public void alsoFails() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(TestConfiguration.class, Config.class);
		assertNotNull(context.getBean("myBean"));
		context.close();
	}

	@Configuration
	@EnableCaching(proxyTargetClass = true)
	public static class TestConfiguration implements CachingConfigurer {

		@Autowired
		private ProxyCachingConfiguration config;

		@Bean
		public Object myBean() {
			return config.cacheInterceptor();
		}

		@Override
		public KeyGenerator keyGenerator() {
			return null;
		}

		@Override
		public CacheManager cacheManager() {
			return new NoOpCacheManager();
		}

	}

	@Configuration
	static class Config {
		@Bean
		Object someBean() {
			return new Object();
		}
	}

}
