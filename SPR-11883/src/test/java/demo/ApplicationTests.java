/*
 * Copyright 20013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

/**
 * @author Dave Syer
 *
 */
public class ApplicationTests {
	
	@Before
	public void init() {
		InitializerConfiguration.initialized = false;
	}

	@Test
	public void succeeds() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Succeeds.class);
		context.close();
	}

	@Test
	public void fails() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Fails.class);
		context.close();
	}

	@Configuration
	@Import(InitializerConfiguration.class)
	protected static class Succeeds {
		
		@Bean
		@DependsOn("initializer")
		public SucceedsConfiguration succeeds() {
			return new SucceedsConfiguration();
		}

		public static void main(String[] args) {
			SpringApplication.run(Fails.class, args);
		}

	}

	@Configuration
	protected static class SucceedsConfiguration {
		@Bean
		public String foo() {
			Assert.state(InitializerConfiguration.initialized);
			return "foo";
		}
	}

	@Configuration
	@Import(InitializerConfiguration.class)
	protected static class Fails {

		@Configuration
		@DependsOn("initializer")
		protected static class ApplicationConfiguration {
			@Bean
			public String foo() {
				Assert.state(InitializerConfiguration.initialized);
				return "foo";
			}
		}

		public static void main(String[] args) {
			SpringApplication.run(Fails.class, args);
		}

	}

	@Configuration
	protected static class InitializerConfiguration {
		
		public static boolean initialized = false;

		@Bean
		public String initializer() {
			initialized = true;
			return "foo";
		}

	}

}
