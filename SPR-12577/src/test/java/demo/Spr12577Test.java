/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 *
 * @author Stephane Nicoll
 */
public class Spr12577Test {

	private ConfigurableApplicationContext context;

	@After
	public void closeContext() {
		if (context != null) {
			context.close();
		}
	}

	@Test
	public void regularJavaConfiguration() {
		this.context = new AnnotationConfigApplicationContext(FooServiceImpl.class, RegularJavaConfiguration.class);
		runTest();
	}


	@Configuration
	@EnableTransactionManagement
	static class RegularJavaConfiguration implements TransactionManagementConfigurer {

		@Override
		public PlatformTransactionManager annotationDrivenTransactionManager() {
			return transactionManager();
		}

		@Bean
		public PlatformTransactionManager transactionManager() {
			return mock(PlatformTransactionManager.class);
		}


		@Bean
		public PlatformTransactionManager anotherTransactionManager() {
			return mock(PlatformTransactionManager.class);
		}

	}


	@Test
	public void primaryJavaConfiguration() {
		this.context = new AnnotationConfigApplicationContext(FooServiceImpl.class, PrimaryJavaConfiguration.class);
		runTest();
	}


	@Configuration
	@EnableTransactionManagement
	static class PrimaryJavaConfiguration {

		@Bean
		@Primary
		public PlatformTransactionManager transactionManager() {
			return mock(PlatformTransactionManager.class);
		}


		@Bean
		public PlatformTransactionManager anotherTransactionManager() {
			return mock(PlatformTransactionManager.class);
		}

	}


	@Test
	public void regularXmlConfiguration() {
		this.context = new ClassPathXmlApplicationContext("classpath:/regular-configuration.xml");
		runTest();
	}

	@Test
	public void primaryXmlConfiguration() {
		this.context = new ClassPathXmlApplicationContext("classpath:/primary-configuration.xml");
		runTest();
	}

	private void runTest() {
		FooService fooService = this.context.getBean(FooService.class);
		PlatformTransactionManager transactionManager =
				this.context.getBean("transactionManager", PlatformTransactionManager.class);
		PlatformTransactionManager anotherTransactionManager =
				this.context.getBean("anotherTransactionManager", PlatformTransactionManager.class);

		fooService.doIt();
		verify(transactionManager, times(1)).getTransaction(any(TransactionDefinition.class));
		verify(anotherTransactionManager, times(0)).getTransaction(any(TransactionDefinition.class));

		fooService.doItAnotherTxManager();
		verify(anotherTransactionManager, times(1)).getTransaction(any(TransactionDefinition.class));
		verify(transactionManager, times(1)).getTransaction(any(TransactionDefinition.class));
	}

}
