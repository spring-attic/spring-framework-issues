package org.springframework.issues;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan
@EnableAsync
public class MyConfiguration extends AsyncConfigurerSupport {

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		final MethodValidationPostProcessor methodValidationPostProcessor;

		methodValidationPostProcessor = new MethodValidationPostProcessor();
		methodValidationPostProcessor.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return methodValidationPostProcessor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncUncaughtExceptionHandler() {
			@Override
			public void handleUncaughtException(Throwable ex, Method method, Object... params) {
				System.out.println("----- exception [" + ex.getClass().getName() + "]");
			}
		};
	}
}
