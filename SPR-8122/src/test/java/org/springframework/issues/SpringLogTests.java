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

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.StandardEnvironment;

public class SpringLogTests {

	@Test
	public void test() {
		//ConfigurableApplicationContext parent = new GenericApplicationContext();
//		parent.refresh();

		ConfigurableApplicationContext child = new ClassPathXmlApplicationContext();
		child.setEnvironment(new StandardEnvironment());
		child.refresh();

		child.close();
//		parent.close();

//		Object ac2 = new GenericXmlApplicationContext();

//		System.out.println(Integer.toHexString(ac1.hashCode()));
//		System.out.println(Integer.toHexString(ac2.hashCode()));
//
//		System.out.println(ac1);
//		System.out.println(ac2);
// 
//		System.out.println(Integer.toHexString(System.identityHashCode(ac1)));
//		System.out.println(Integer.toHexString(System.identityHashCode(ac2)));
//
//		SpringLog log = new SpringLog(this);
//		log.info(SpringSubsystem.CONTEXT, "hello from context");
//		log.info(SpringSubsystem.JDBC_OPERATIONS, "hello from jdbc");
//		log.info(SpringSubsystem.DIAGNOSTICS, "a diagnostic message");
	}
}
