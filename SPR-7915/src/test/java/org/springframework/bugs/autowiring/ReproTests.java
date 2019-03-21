/*
 * Copyright 2002-2011 the original author or authors.
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

package org.springframework.bugs.autowiring;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ReproTests {
	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyComponent.class);
		ctx.register(MyConfig.class);
		ctx.refresh();
		System.out.println(ctx.getBean(MyComponent.class).beans);
	}

	static class MyComponent {
		@Autowired
		Whatev beans;
	}

	static class Foo { }

	static class MyConfig {
		/*
		@Bean
		public Map<String, Object> beans() {
			return new LinkedHashMap<String, Object>();
		}
		*/
		@Bean
		public SomeMap smap() {
			return new SomeMap();
		}
	}

	interface Whatev extends Map<String, Object> { }

	@SuppressWarnings("serial")
	static class SomeMap extends LinkedHashMap<String, Object> implements Whatev {
		
	}
}
