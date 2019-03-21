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

package org.springframework.web.issues;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.issues.SimpleBean.MyBeanClass;

public class SimpleBeanAccessTests {
	
	@Test
	public void test() {

		XmlWebApplicationContext wac = new XmlWebApplicationContext();
		wac.setConfigLocation("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		wac.setServletContext(new MockServletContext());
		wac.refresh();
		
		ServletWebRequest webRequest = new ServletWebRequest(new MockHttpServletRequest());
		RequestContextHolder.setRequestAttributes(webRequest);
		
		MyBeanClass myBeanClass = wac.getBean("myBeanClass", MyBeanClass.class);
		assertNull(myBeanClass);
		
		MyBeanClass myProxiedBeanClass = wac.getBean("myProxiedBeanClass", MyBeanClass.class);
		assertNotNull(myProxiedBeanClass);
		assertEquals("foo", myProxiedBeanClass.getFoo());	// this will cause NPE

		RequestContextHolder.resetRequestAttributes();
	}
	
}
