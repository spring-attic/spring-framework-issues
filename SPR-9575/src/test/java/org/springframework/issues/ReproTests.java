/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.issues;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

public class ReproTests {

	@Test
	public void repro() throws IOException, InterruptedException, ExecutionException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Config.class);
		ctx.refresh();
		AsyncProcess bean = ctx.getBean(AsyncProcess.class);
		assertThat(AopUtils.isAopProxy(bean), is(true));
		Future<String> result = bean.findBalanceAsync("123");
		assertThat(result.get().contains("ppte-"), is(true));
	}

	@Configuration
	@EnableAsync(proxyTargetClass=true)
	static class Config {
		@Bean
		public AsyncProcess asyncProcess() {
			return new AsyncProcess();
		}

		@Bean
		public SimpleAsyncTaskExecutor portalPoolTaskExecutor() {
			return new SimpleAsyncTaskExecutor("ppte-");
		}
	}
}
