/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springsource.investigation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ReproTests {
	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().addActiveProfile("prod");
		ctx.register(App.class);
		ctx.refresh();
		String testBean = ctx.getBean("testBean", String.class);
		assertThat(testBean, equalTo("testBeanValue"));
		String appId = ctx.getEnvironment().getProperty("appId");
		assertThat(appId, equalTo("prod"));
	}

}
