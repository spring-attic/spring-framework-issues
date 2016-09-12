package com.example;

import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.test.util.ReflectionTestUtils;

public class ProxyApplicationTests {

	private Set<Class<?>> classes = new HashSet<>();

	@Test
	public void contextLoads() {
		System.err.println(count());
		runAndClose();
		System.err.println(count());
		runAndClose();
		System.err.println(count());
		runAndClose();
		System.err.println(count());
		runAndClose();
		System.err.println(count());
	}

	@SuppressWarnings("resource")
	private void runAndClose() {
		ConfigurableApplicationContext run = new AnnotationConfigApplicationContext(Empty.class);
		run.close();
		while (run.getParent() != null) {
			((ConfigurableApplicationContext) run.getParent()).close();
			run = (ConfigurableApplicationContext) run.getParent();
		}
	}

	private int count() {
		URLClassLoader classLoader = (URLClassLoader) getClass().getClassLoader();
		@SuppressWarnings("unchecked")
		Vector<Class<?>> classes = (Vector<Class<?>>) ReflectionTestUtils
				.getField(classLoader, "classes");
		Set<Class<?>> news = new HashSet<>();
		for (Iterator<Class<?>> iterator = classes.iterator(); iterator.hasNext();) {
			Class<?> cls = (Class<?>) iterator.next();
			if (!this.classes.contains(cls)) {
				news.add(cls);
			}
		}
		System.err.println(news);
		this.classes.addAll(classes);
		return classes.size();
	}

	@Configuration
	@EnableRetry(proxyTargetClass = true)
	protected static class Empty {

		@Bean
		public Service service() {
			return new Service();
		}

	}

	@Component
	static class Service {

		@Retryable
		public void handle() {
			System.err.println("Handling");
		}

	}

}
