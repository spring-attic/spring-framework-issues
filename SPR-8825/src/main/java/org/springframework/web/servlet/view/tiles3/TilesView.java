/*
 * Copyright 2011 the original author or authors.
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

import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.impl.BasicTilesContainer;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

import org.springframework.web.servlet.support.JstlUtils;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.util.WebUtils;

/**
 * {@link org.springframework.web.servlet.View} implementation that retrieves a
 * Tiles definition. The "url" property is interpreted as name of a Tiles definition.
 *
 * <p>This class builds on Tiles3, which requires JSP 2.0.
 * JSTL support is integrated out of the box due to JSTL's inclusion in JSP 2.0.
 *
 * <p>Depends on a TilesContainer which must be available in
 * the ServletContext. This container is typically set up via a
 * {@link TilesConfigurer} bean definition in the application context.
 *
 * @see #setUrl
 * @see TilesConfigurer
 */
public class TilesView extends AbstractUrlBasedView {

	private volatile boolean exposeForwardAttributes = false;


	/**
	 * Checks whether we need to explicitly expose the Servlet 2.4 request attributes
	 * by default.
	 * <p>This will be done by default on Servlet containers up until 2.4, and skipped
	 * for Servlet 2.5 and above. Note that Servlet containers at 2.4 level and above
	 * should expose those attributes automatically! This feature exists for
	 * Servlet 2.3 containers and misbehaving 2.4 containers only.
	 */
	@Override
	protected void initServletContext(final ServletContext sc) {
		if (sc.getMajorVersion() == 2 && sc.getMinorVersion() < 5) {
			this.exposeForwardAttributes = true;
		}
	}


	@Override
	public boolean checkResource(final Locale locale) throws Exception {
		TilesContainer container = TilesAccess.getContainer(ServletUtil.getApplicationContext(getServletContext()));
        String definition = getUrl();
		ApplicationContext appContext = new ServletApplicationContext(getServletContext());
		Request request = new ServletRequest(appContext, null, null) {
			@Override
			public Locale getRequestLocale() {
				return locale;
			}
		};
        return container.isValidDefinition(definition, request) && null != container.getDefinition(definition, request);
	}

	@Override
	protected void renderMergedOutputModel(
            final Map<String, Object> model,
            final HttpServletRequest request,
            final HttpServletResponse response) throws Exception {

		ServletContext servletContext = getServletContext();
        ApplicationContext tilesContext = ServletUtil.getApplicationContext(getServletContext());
		TilesContainer container = TilesAccess.getContainer(tilesContext);
		if (container == null) {
			throw new ServletException("Tiles container is not initialized. "
					+ "Have you added a TilesConfigurer to your web application context?");
		}

		exposeModelAsRequestAttributes(model, request);
		JstlUtils.exposeLocalizationContext(new RequestContext(request, servletContext));

		if (!response.isCommitted()) {
			// Tiles is going to use a forward, but some web containers (e.g. OC4J 10.1.3)
			// do not properly expose the Servlet 2.4 forward request attributes... However,
			// must not do this on Servlet 2.5 or above, mainly for GlassFish compatibility.
			if (this.exposeForwardAttributes) {
				try {
					WebUtils.exposeForwardRequestAttributes(request);
				}
				catch (Exception ex) {
					// Servlet container rejected to set internal attributes, e.g. on TriFork.
					this.exposeForwardAttributes = false;
				}
			}
		}

		container.render(getUrl(), new ServletRequest(tilesContext, request, response));
	}

}
