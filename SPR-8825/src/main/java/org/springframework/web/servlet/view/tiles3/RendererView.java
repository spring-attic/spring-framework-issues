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

import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.apache.tiles.request.servlet.ServletRequest;
import org.springframework.web.servlet.support.JstlUtils;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.util.WebUtils;

/**
 * {@link org.springframework.web.servlet.View} implementation that renders
 * through the Tiles Request API. The "url" property is interpreted as name of a
 * Tiles definition.
 *
 * @author Nicolas Le Bas
 * @author mick semb wever
 * @since 3.2
 */
public class RendererView extends AbstractUrlBasedView {
	private ApplicationContext applicationContext;
	private Renderer renderer;
	private boolean exposeForwardAttributes = false;
	private boolean exposeJstlAttributes = true;

	@Override
	protected void initServletContext(ServletContext servletContext) {
		super.initServletContext(servletContext);
		if (servletContext.getMajorVersion() == 2 && servletContext.getMinorVersion() < 5) {
			this.exposeForwardAttributes = true;
		}
	}

	public void setTilesApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

	protected void setExposeJstlAttributes(boolean exposeJstlAttributes) {
		this.exposeJstlAttributes = exposeJstlAttributes;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		exposeModelAsRequestAttributes(model, request);

		if (this.exposeJstlAttributes) {
			ServletContext servletContext = getServletContext();
			JstlUtils.exposeLocalizationContext(new RequestContext(request, servletContext));
		}

		if (!response.isCommitted()) {
			// Tiles is going to use a forward, but some web containers (e.g.
			// OC4J 10.1.3)
			// do not properly expose the Servlet 2.4 forward request
			// attributes... However,
			// must not do this on Servlet 2.5 or above, mainly for GlassFish
			// compatibility.
			if (this.exposeForwardAttributes) {
				try {
					WebUtils.exposeForwardRequestAttributes(request);
				} catch (Exception ex) {
					// Servlet container rejected to set internal attributes,
					// e.g. on TriFork.
					this.exposeForwardAttributes = false;
				}
			}
		}

		Request tilesRequest = createRequest(request, response, this.applicationContext);
		if (this.renderer.isRenderable(getUrl(), tilesRequest)) {
			this.renderer.render(getUrl(), tilesRequest);
		}
	}

	protected Request createRequest(HttpServletRequest request, HttpServletResponse response, ApplicationContext context) {
		ServletRequest tilesRequest = new ServletRequest(context, request, response);
		Locale locale = RequestContextUtils.getLocale(request);
		return new SpringRequest(tilesRequest, locale);
	}
}
