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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.render.Renderer;
import org.apache.tiles.request.servlet.ServletRequest;
import org.springframework.web.servlet.view.AbstractTemplateView;

public class RendererView extends AbstractTemplateView {
    private ApplicationContext applicationContext;
    private Renderer renderer;
    private Locale locale;
    private boolean exposeModelInRequest = true;

    public RendererView(ApplicationContext applicationContext, Renderer renderer, String path, Locale locale) {
        super.setUrl(path);
        this.applicationContext = applicationContext;
        this.renderer = renderer;
        this.locale = locale;
    }

    /**
     * Set whether all request attributes should be added to the
     * model prior to merging with the template. Default is "false".
     */
    public void setExposeModelInRequest(boolean exposeModelInRequest) {
        this.exposeModelInRequest = exposeModelInRequest;
    }

    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        if (exposeModelInRequest) {
            exposeModelAsRequestAttributes(model, request);
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
