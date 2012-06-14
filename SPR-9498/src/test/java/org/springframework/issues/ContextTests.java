/*
 * Cloud Foundry 2012.02.03 Beta
 * Copyright (c) [2009-2012] VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product includes a number of subcomponents with
 * separate copyright notices and license terms. Your use of these
 * subcomponents is subject to the terms and conditions of the
 * subcomponent's license, as noted in the LICENSE file.
 */

package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Dave Syer
 *
 */
public class ContextTests {

	private MockHttpServletRequest request = new MockHttpServletRequest();

	@Before
	public void initScopes() {
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		LocaleContextHolder.setLocale(request.getLocale(), true);
		RequestContextHolder.setRequestAttributes(attributes, true);
	}

	@After
	public void clearScopes() {
		LocaleContextHolder.resetLocaleContext();
		RequestContextHolder.resetRequestAttributes();
	}

	@Test
	public void testOK() {
		request.setParameter("foo", "bar");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:/ok-context.xml");
		Foo foo = context.getBean(Foo.class);
		assertNotNull(foo);
		assertEquals("bar", foo.getBar().getFirst("foo"));
	}

	@Test
	public void testFails() {
		request.setParameter("foo", "bar");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:/test-context.xml");
		Foo foo = context.getBean(Foo.class);
		assertNotNull(foo);
		assertEquals("bar", foo.getBar().getFirst("foo"));
	}

}
