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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StaticWebApplicationContext;

public class RendererViewResolverTest {

	private TilesViewResolver testTarget;
	private ApplicationContext tilesContext;
	private StaticWebApplicationContext springContext;
	private AutowireCapableBeanFactory beanFactory;
	private TilesContainer tilesContainer;
	private Renderer renderer;
	private String contentType;
	private Locale locale;

	@Before
	public void setUp() {
		tilesContext = createMock(ApplicationContext.class);

		springContext = new StaticWebApplicationContext();
		springContext.setServletContext(new MockServletContext());
		springContext.refresh();

		beanFactory = createMock(AutowireCapableBeanFactory.class);
		tilesContainer = createMock(TilesContainer.class);
		renderer = createMock(Renderer.class);
		Map<String, Object> appScope = new HashMap<String, Object>();
		appScope.put(TilesAccess.CONTAINER_ATTRIBUTE, tilesContainer);
		expect(tilesContext.getApplicationScope()).andReturn(appScope).anyTimes();
		expect(tilesContext.getContext()).andReturn(springContext).anyTimes();
		contentType = "application/test";
		locale = Locale.ITALY;
		testTarget = new TilesViewResolver();
		testTarget.setRenderer(renderer);
		testTarget.setContentType(contentType);
	}

	@Test
	public void testResolve() throws Exception {
		expect(renderer.isRenderable(eq("/template.test"), isA(Request.class))).andReturn(true);
		expect(renderer.isRenderable(eq("/nonexistent.test"), isA(Request.class))).andReturn(false);
		replay(tilesContext, beanFactory, renderer);
		testTarget.setApplicationContext(springContext);
		assertTrue(testTarget.resolveViewName("/template.test", locale) instanceof TilesView);
		assertNull(testTarget.resolveViewName("/nonexistent.test", locale));
		verify(tilesContext, beanFactory, renderer);
	}
}
