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

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.render.Renderer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Convenience subclass of {@link UrlBasedViewResolver} that supports
 * {@link RendererView} (i.e. Tiles definitions) and custom subclasses of it.
 *
 * <p>
 * The renderer class used by this resolver is specified via the "renderer"
 * property. If not specified it defaults to a DefinitionRenderer. This default
 * relies depends on a TilesContainer which must be available in the
 * ApplicationContext. This container is typically set up via a
 * {@link TilesConfigurer} bean definition in the application context. A typical
 * bean definition is just:
 *
 * <pre>
 * &lt;bean id="viewResolver" class="org.springframework.web.servlet.view.tiles3.RendererViewResolver"/>
 * </pre>
 *
 *
 * @author Nicolas Le Bas
 * @since 3.2
 * @see RendererView
 */
public class RendererViewResolver extends UrlBasedViewResolver {

	private ApplicationContext tilesContext;
	private Renderer renderer;

	@Override
	@SuppressWarnings("rawtypes")
	protected Class getViewClass() {
		return RendererView.class;
	}

	/**
	 * Defaults to any suitable ApplicationContext configured in spring.
	 *
	 * @param tilesContext the tilesContext to set
	 */
	public void setTilesContext(ApplicationContext tilesContext) {
		this.tilesContext = tilesContext;
	}

	/**
	 * Get the TilesContext in use.
	 *
	 * @return the tilesContext in use
	 */
	public ApplicationContext getTilesContext() {
		return tilesContext;
	}

	/**
	 * Must be set. Use {@link TilesViewResolver} to set it up for Apache Tiles.
	 *
	 * @param renderer the renderer to set
	 */
	public void setRenderer(Renderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * Get the Renderer in use.
	 *
	 * @return the Renderer in use
	 */
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	protected void initApplicationContext(org.springframework.context.ApplicationContext context) {
		super.initApplicationContext(context);
		if (this.tilesContext == null) {
			this.tilesContext = context.getBean(ApplicationContext.class);
			if (this.tilesContext == null) {
				throw new IllegalStateException("no ApplicationContext bean found");
			}
		}
	}

	@Override
	protected RendererView buildView(String viewName) throws Exception {
		RendererView view = (RendererView) super.buildView(viewName);
		view.setTilesApplicationContext(this.tilesContext);
		view.setRenderer(this.renderer);
		return view;
	}

}
