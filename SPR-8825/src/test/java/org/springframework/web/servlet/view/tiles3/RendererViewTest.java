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
package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.and;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.impl.BasicTilesContainer;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.easymock.Capture;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.theme.FixedThemeResolver;

public class RendererViewTest {
	private TilesView testTarget;
	private ApplicationContext applicationContext;
	private Renderer renderer;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private Map<String, Object> model;
	private String path;
	private String contentType;
	private Locale locale;
	private StaticWebApplicationContext springContext;

	@Before
	public void setUp() {
		springContext = new StaticWebApplicationContext();
		springContext.setServletContext(new MockServletContext());
		springContext.refresh();

		path = "/template.test";
		contentType = "application/test";
		locale = Locale.ITALY;

		request = new MockHttpServletRequest();
		request.setAttribute(DispatcherServlet.WEB_APPLICATION_CONTEXT_ATTRIBUTE, springContext);
		request.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, new AcceptHeaderLocaleResolver());
		request.setAttribute(DispatcherServlet.THEME_RESOLVER_ATTRIBUTE, new FixedThemeResolver());
		request.addPreferredLocale(locale);

		response = new MockHttpServletResponse();
		response.setContentType(contentType);

		applicationContext = createMock(ApplicationContext.class);
		Map<String, Object> appScope = new HashMap<String, Object>();
		appScope.put(TilesAccess.CONTAINER_ATTRIBUTE, new BasicTilesContainer());
		expect(applicationContext.getApplicationScope()).andReturn(appScope).anyTimes();
		renderer = createMock(Renderer.class);
		model = new HashMap<String, Object>();
		model.put("modelAttribute", "modelValue");
		testTarget = new TilesView();
		testTarget.setTilesApplicationContext(applicationContext);
		testTarget.setRenderer(renderer);
		testTarget.setUrl(path);
	}

	@Test
	public void testRender() throws Exception {
		request.setAttribute("modelAttribute", "modelValue");
		Capture<Request> renderableRequest = new Capture<Request>();
		expect(renderer.isRenderable(eq(path), and(isA(Request.class), capture(renderableRequest)))).andReturn(true);
		Capture<Request> renderRequest = new Capture<Request>();
		renderer.render(eq(path), and(isA(Request.class), capture(renderRequest)));
		replay(applicationContext, renderer);
		testTarget.setApplicationContext(springContext);
		testTarget.setContentType(contentType);
		testTarget.render(model, request, response);
		assertEquals(renderableRequest.getValue().getRequestLocale(), locale);
		assertSame("isRenderable and render received different requests", renderableRequest.getValue(),
				renderRequest.getValue());
		verify(applicationContext, renderer);
	}

	@Test
	public void testRenderNoAttributes() throws Exception {
		Capture<Request> renderableRequest = new Capture<Request>();
		expect(renderer.isRenderable(eq(path), and(isA(Request.class), capture(renderableRequest)))).andReturn(true);
		Capture<Request> renderRequest = new Capture<Request>();
		renderer.render(eq(path), and(isA(Request.class), capture(renderRequest)));
		replay(applicationContext, renderer);
		testTarget.setApplicationContext(springContext);
		testTarget.setContentType(contentType);
		testTarget.render(model, request, response);
		assertEquals(renderableRequest.getValue().getRequestLocale(), locale);
		assertSame("isRenderable and render received different requests", renderableRequest.getValue(),
				renderRequest.getValue());
		verify(applicationContext, renderer);
	}

	@Test
	public void testNotRenderable() throws Exception {
		expect(renderer.isRenderable(eq(path), isA(Request.class))).andReturn(false);
		replay(applicationContext, renderer);
		testTarget.setApplicationContext(springContext);
		testTarget.setContentType(contentType);
		testTarget.render(model, request, response);
		verify(applicationContext, renderer);
	}
}
