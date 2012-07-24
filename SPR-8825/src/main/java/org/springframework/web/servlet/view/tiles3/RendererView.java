/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
import org.springframework.web.servlet.view.AbstractTemplateView;
import org.springframework.web.util.WebUtils;

/**
 * {@link org.springframework.web.servlet.View} implementation that renders through the
 * Tiles Request API. The "url" property is interpreted as name of a Tiles definition.
 *
 * @author Nicolas Le Bas
 * @author mick semb wever
 * @since 3.2
 */
public class RendererView extends AbstractTemplateView {
    private ApplicationContext applicationContext;
    private Renderer renderer;
    private Locale locale;
    private boolean exposeModelInRequest = true;
    private boolean exposeForwardAttributes = false;

    public RendererView(ApplicationContext applicationContext, Renderer renderer, String path, Locale locale) {
        super.setUrl(path);
        this.applicationContext = applicationContext;
        this.renderer = renderer;
        this.locale = locale;
    }

    @Override
    protected void initServletContext(ServletContext servletContext) {
        super.initServletContext(servletContext);
        if (servletContext.getMajorVersion() == 2 && servletContext.getMinorVersion() < 5) {
            this.exposeForwardAttributes = true;
        }
    }

    /**
     * Set whether all request attributes should be added to the
     * model prior to merging with the template. Default is "false".
     */
    public void setExposeModelInRequest(boolean exposeModelInRequest) {
        this.exposeModelInRequest = exposeModelInRequest;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (exposeModelInRequest) {
            exposeModelAsRequestAttributes(model, request);
        }

        // Tiles is going to use a forward, but some web containers (e.g. OC4J 10.1.3)
        // do not properly expose the Servlet 2.4 forward request attributes... However,
        // must not do this on Servlet 2.5 or above, mainly for GlassFish compatibility.
        if (!response.isCommitted() && this.exposeForwardAttributes) {
           try {
               WebUtils.exposeForwardRequestAttributes(request);
           } catch (Exception ex) {
               // Servlet container rejected to set internal attributes, e.g. on TriFork.
               this.exposeForwardAttributes = false;
           }
        }

        Request tilesRequest = createRequest(request, response, applicationContext);
        if (renderer.isRenderable(getUrl(), tilesRequest)) {
            renderer.render(getUrl(), tilesRequest);
        }
    }

    protected Request createRequest(HttpServletRequest request, HttpServletResponse response, ApplicationContext context) {
        ServletRequest tilesRequest = new ServletRequest(context, request, response);
        return new SpringRequest(tilesRequest, locale);
    }
}
