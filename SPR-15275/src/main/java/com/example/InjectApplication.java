package com.example;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InjectApplication {

	private Foo foo = new Foo();

	@Bean
	public Another another() throws Exception {
		return new Another(foo().getObject());
	}

	@Bean
	public FactoryBean<Bar> foo() {
		return new AbstractFactoryBean<Bar>() {

			@Override
			public Class<?> getObjectType() {
				return Bar.class;
			}

			@Override
			protected Bar createInstance() throws Exception {
				return foo;
			}
		};
	}

	@Bean
	public FactoryBean<Spam> spam() {
		return new AbstractFactoryBean<Spam>() {

			@Override
			public Class<?> getObjectType() {
				return Spam.class;
			}

			@Override
			protected Spam createInstance() throws Exception {
				return foo;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InjectApplication.class, args);
	}

	public interface Bar {
	}

	public interface Spam {
	}

	public static class Foo implements Bar, Spam {
	}

	public static class Another {
		private Bar bar;

		public Another(Bar bar) {
			this.bar = bar;
		}
	}

}
