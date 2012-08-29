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

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.DispatchRequest;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.attribute.Addable;
import org.apache.tiles.request.render.Renderer;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * Convenience subclass of {@link org.springframework.web.servlet.view.AbstractCachingViewResolver} that supports
 * {@link RendererView} (i.e. Tiles definitions) and custom subclasses of it.
 *
 * <p>The renderer class used by this resolver is specified via the "renderer" property.
 * If not specified it defaults to a DefinitionRenderer.
 * This default relies depends on a TilesContainer which must be available in
 * the ApplicationContext. This container is typically set up via a
 * {@link TilesConfigurer} bean definition in the application context.
 * A typical bean definition is just:
 *
 * <pre>&lt;bean id="viewResolver" class="org.springframework.web.servlet.view.tiles3.RendererViewResolver"/></pre>
 *
 *
 * @author Nicolas Le Bas
 * @since 3.2
 * @see RendererView
 */
public class RendererViewResolver extends AbstractTemplateViewResolver {

    private ApplicationContext tilesContext;
    private Renderer renderer;
    private boolean exposeModelInRequest = true;
    private Map<Locale, Request> localeRequests = new HashMap<Locale, Request>();
    static final List<String> SCOPES = Arrays.asList("application", "session", "request");

    @Override
    @SuppressWarnings("rawtypes")
    protected Class getViewClass() {
        return RendererView.class;
    }

    /** Defaults to any suitable ApplicationContext configured in spring.
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
    
    /**
     * @param exposeSpringMacroHelpers the exposeInRequest to set
     */
    public void setExposeModelInRequest(boolean exposeModelInRequest) {
        this.exposeModelInRequest = exposeModelInRequest;
    }

    @Override
    protected void initApplicationContext(org.springframework.context.ApplicationContext context) {
        super.initApplicationContext(context);
        if (this.tilesContext == null) {
            this.tilesContext = context.getBean(ApplicationContext.class);
            if(this.tilesContext == null) {
                throw new IllegalStateException("no ApplicationContext bean found");
            }
        }
    }

    private Request getLocaleRequest(Locale locale) {
        synchronized (localeRequests) {
            Request result = localeRequests.get(locale);
            if (result == null) {
                result = new SpringRequest(new DispatchRequest() {
                    @Override
                    public boolean isUserInRole(String role) {
                        return true;
                    }
                    @Override
                    public boolean isResponseCommitted() {
                        return true;
                    }
                    @Override
                    public Writer getWriter() throws IOException {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public Addable<String> getResponseHeaders() {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public Locale getRequestLocale() {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public PrintWriter getPrintWriter() throws IOException {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public Map<String, String[]> getParamValues() {
                        return Collections.<String, String[]> emptyMap();
                    }
                    @Override
                    public Map<String, String> getParam() {
                        return Collections.<String, String> emptyMap();
                    }
                    @Override
                    public OutputStream getOutputStream() throws IOException {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public Map<String, String[]> getHeaderValues() {
                        return Collections.<String, String[]> emptyMap();
                    }
                    @Override
                    public Map<String, String> getHeader() {
                        return Collections.<String, String> emptyMap();
                    }
                    @Override
                    public Map<String, Object> getContext(String scope) {
                        return Collections.<String, Object> emptyMap();
                    }
                    @Override
                    public List<String> getAvailableScopes() {
                        return Collections.<String> emptyList();
                    }
                    @Override
                    public ApplicationContext getApplicationContext() {
                        return RendererViewResolver.this.tilesContext;
                    }
                    @Override
                    public void dispatch(String path) throws IOException {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public void include(String path) throws IOException {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                    @Override
                    public void setContentType(String contentType) {
                        throw new UnsupportedOperationException("Dummy request");
                    }
                }, locale);
                localeRequests.put(locale, result);
            }
            return result;
        }
    }

    @Override
    protected RendererView loadView(String viewName, Locale locale) throws Exception {
        if (renderer.isRenderable(getPrefix() + viewName + getSuffix(), getLocaleRequest(locale))) {
            RendererView view = (RendererView) super.loadView(viewName, locale);
            view.setLocale(locale);
            return view;
        } else {
            return null;
        }
    }

    @Override
    protected RendererView buildView(String viewName) throws Exception {
        RendererView view = (RendererView) super.buildView(viewName);
        view.setTilesApplicationContext(tilesContext);
        view.setRenderer(renderer);
        view.setUrl(getPrefix() + viewName + getSuffix());
        view.setExposeModelInRequest(exposeModelInRequest);
        return view;
    }

}
