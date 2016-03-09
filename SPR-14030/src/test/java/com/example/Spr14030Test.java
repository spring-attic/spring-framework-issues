package com.example;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Spr14030Test {

	@Test
	public void test() throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
		TestAsync testAsync = context.getBean(TestAsync.class);
		try {
			assertThat(testAsync.getInvocationThread().getName(), is(not(equalTo("main"))));
		} finally {
			context.close();
		}
	}

	@Configuration
	@EnableAsync
	static class TestConfiguration {

		@Autowired
		private TestAsync testAsync;

		@PostConstruct
		public void postConstruct() {
			testAsync.doSomething();
		}

		@Bean
		public ThreadPoolTaskExecutor testTaskExecutor() {
			return new ThreadPoolTaskExecutor();
		}

		@Bean
		public TestAsync testAsync() {
			return new TestAsync();
		}

	}

	static class TestAsync {

		private final CountDownLatch latch = new CountDownLatch(1);

		private volatile Thread thread = null;

		@Async
		public void doSomething() {
			this.thread = Thread.currentThread();
			this.latch.countDown();
		}

		Thread getInvocationThread() throws InterruptedException {
			this.latch.await();
			return this.thread;
		}
	}

}
