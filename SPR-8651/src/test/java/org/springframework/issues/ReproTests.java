package org.springframework.issues;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.CallCountingTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Unsucessfully attempts to reproduce the issue described by SPR-8651, in which
 * @Scheduled methods within @Repository-annotated components cause an exception.
 *
 * @author Chris Beams
 */
public class ReproTests {

	@Test
	public void repro() throws InterruptedException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ReproConfig.class);
		ctx.refresh();

		Thread.sleep(10); // allow @Scheduled method to be called several times

		MyRepository repository = ctx.getBean(MyRepository.class);
		assertThat("repository is not a proxy", AopUtils.isAopProxy(repository), is(true));
		assertThat("@Scheduled method never called", repository.getInvocationCount(), greaterThan(0));
	}


	@Configuration
	@EnableScheduling
	@EnableTransactionManagement(proxyTargetClass=true)
	static class ReproConfig {

		@Bean
		public MyRepository repository() {
			return new MyRepositoryImpl();
		}

		@Bean
		public PersistenceExceptionTranslationPostProcessor peTranslationPostProcessor() {
			return new PersistenceExceptionTranslationPostProcessor();
		}

		@Bean
		public PlatformTransactionManager txManager() {
			return new CallCountingTransactionManager();
		}

		@Bean
		public PersistenceExceptionTranslator peTranslator() {
			PersistenceExceptionTranslator txlator = createMock(PersistenceExceptionTranslator.class);
			replay(txlator);
			return txlator;
		}
	}
}
