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
import org.apache.tiles.request.Request;
import org.apache.tiles.request.attribute.Addable;
import org.apache.tiles.request.render.Renderer;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;


public class RendererViewResolver extends AbstractCachingViewResolver {

    private ApplicationContext tilesContext;
    private Renderer renderer;
    private String prefix;
    private String suffix;
    private String contentType;
    private Map<String, Object> attributesMap;
    private String requestContextAttribute;
    private boolean exposeRequestAttributes = false;
    private boolean allowRequestOverride = false;
    private boolean exposeSessionAttributes = false;
    private boolean allowSessionOverride = false;
    private boolean exposeSpringMacroHelpers = true;
    private boolean exposeModelInRequest = true;
    private String[] viewNames = null;
    private Map<Locale, Request> localeRequests = new HashMap<Locale, Request>();
    static final List<String> SCOPES = Arrays.asList("application", "session", "request");


    /**
     * @param tilesContext the tilesContext to set
     */
    public void setTilesContext(ApplicationContext tilesContext) {
        this.tilesContext = tilesContext;
    }
    /**
     * @param renderer the renderer to set
     */
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
    /**
     * @param prefix the prefix to set
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    /**
     * @param suffix the suffix to set
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    /**
     * @param attributesMap the attributesMap to set
     */
    public void setAttributesMap(Map<String, Object> attributesMap) {
        this.attributesMap = attributesMap;
    }
    /**
     * @param requestContextAttribute the requestContextAttribute to set
     */
    public void setRequestContextAttribute(String requestContextAttribute) {
        this.requestContextAttribute = requestContextAttribute;
    }
    /**
     * @param exposeRequestAttributes the exposeRequestAttributes to set
     */
    public void setExposeRequestAttributes(boolean exposeRequestAttributes) {
        this.exposeRequestAttributes = exposeRequestAttributes;
    }
    /**
     * @param allowRequestOverride the allowRequestOverride to set
     */
    public void setAllowRequestOverride(boolean allowRequestOverride) {
        this.allowRequestOverride = allowRequestOverride;
    }
    /**
     * @param exposeSessionAttributes the exposeSessionAttributes to set
     */
    public void setExposeSessionAttributes(boolean exposeSessionAttributes) {
        this.exposeSessionAttributes = exposeSessionAttributes;
    }
    /**
     * @param allowSessionOverride the allowSessionOverride to set
     */
    public void setAllowSessionOverride(boolean allowSessionOverride) {
        this.allowSessionOverride = allowSessionOverride;
    }
    /**
     * @param exposeSpringMacroHelpers the exposeSpringMacroHelpers to set
     */
    public void setExposeSpringMacroHelpers(boolean exposeSpringMacroHelpers) {
        this.exposeSpringMacroHelpers = exposeSpringMacroHelpers;
    }
    /**
     * @param exposeSpringMacroHelpers the exposeInRequest to set
     */
    public void setExposeModelInRequest(boolean exposeModelInRequest) {
        this.exposeModelInRequest = exposeModelInRequest;
    }

    public void setViewNames(String[] viewNames) {
        this.viewNames = viewNames;
    }

    /** {@inheritDoc} */
    @Override
    protected void initApplicationContext(org.springframework.context.ApplicationContext context) {
        super.initApplicationContext(context);
        if (this.tilesContext == null) {
            SpringApplicationContext sac = new SpringApplicationContext();
            sac.setApplicationContext(context);
            this.tilesContext = sac;
        }
    }

    private Request getLocaleRequest(Locale locale) {
        synchronized (localeRequests) {
            Request result = localeRequests.get(locale);
            if (result == null) {
                result = new SpringRequest(new Request() {

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
                } , locale);
                localeRequests.put(locale, result);
            }
            return result;
        }
    }
    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        if(viewNames != null) {
            if(!PatternMatchUtils.simpleMatch(viewNames, viewName)) {
                return null;
            }
        }
        StringBuilder targetViewNameBuilder = new StringBuilder();
        if(prefix != null) {
            targetViewNameBuilder.append(prefix);
        }
        targetViewNameBuilder.append(viewName);
        if(suffix != null) {
            targetViewNameBuilder.append(suffix);
        }
        String targetViewName = targetViewNameBuilder.toString();
        if (renderer.isRenderable(targetViewName.toString(), getLocaleRequest(locale))) {
            RendererView view = new RendererView(this.tilesContext, this.renderer, targetViewName.toString(), locale);
            if (this.contentType != null) {
                view.setContentType(this.contentType);
            }
            view.setRequestContextAttribute(this.requestContextAttribute);
            view.setAttributesMap(this.attributesMap);
            view.setExposeRequestAttributes(this.exposeRequestAttributes);
            view.setAllowRequestOverride(this.allowRequestOverride);
            view.setExposeSessionAttributes(this.exposeSessionAttributes);
            view.setAllowSessionOverride(this.allowSessionOverride);
            view.setExposeSpringMacroHelpers(this.exposeSpringMacroHelpers);
            view.setExposeModelInRequest(exposeModelInRequest);
            View result = (View) getApplicationContext().getAutowireCapableBeanFactory().initializeBean(view, viewName);
            return result;
        } else {
            return null;
        }
    }
}
