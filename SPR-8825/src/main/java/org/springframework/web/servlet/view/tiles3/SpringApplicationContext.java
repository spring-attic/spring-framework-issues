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
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.attribute.HasKeys;
import org.apache.tiles.request.collection.ReadOnlyEnumerationMap;
import org.apache.tiles.request.locale.URLApplicationResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

/**
 * An {@link org.apache.tiles.request.ApplicationContext} based on Spring's {@link ApplicationContext}.
 *
 */
public class SpringApplicationContext implements org.apache.tiles.request.ApplicationContext, ApplicationContextAware {
    private static final Map<String, String> DEFAULT_INIT_PARAMS = new HashMap<String, String>();

    private Map<String, Object> applicationScope;
    private ApplicationContext applicationContext;
    private Map<String, String> initParams = Collections.unmodifiableMap(DEFAULT_INIT_PARAMS);

    private final class SpringApplicationScopeExtractor implements HasKeys<Object> {
        @Override
        public Enumeration<String> getKeys() {
            return Collections.enumeration(Arrays.asList(SpringApplicationContext.this.applicationContext
                    .getBeanDefinitionNames()));
        }

        @Override
        public Object getValue(String key) {
            return SpringApplicationContext.this.applicationContext.getBean(key);
        }
    }

    @Override
    public ApplicationContext getContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        applicationScope = new ReadOnlyEnumerationMap<Object>(new SpringApplicationScopeExtractor());
    }

    @Override
    public Map<String, Object> getApplicationScope() {
        return applicationScope;
    }

    public void setInitParams(Map<String, String> initParams) {
        Map<String, String> paramMap = new HashMap<String, String>(DEFAULT_INIT_PARAMS);
        paramMap.putAll(initParams);
        this.initParams = Collections.unmodifiableMap(paramMap);
    }

    @Override
    public Map<String, String> getInitParams() {
        return initParams;
    }

    @Override
    public ApplicationResource getResource(String localePath) {
        try {
            URL url = applicationContext.getResource(localePath).getURL();
            if (url == null) {
                return null;
            } else {
                return new URLApplicationResource(url.toExternalForm(), url);
            }
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public ApplicationResource getResource(ApplicationResource base, Locale locale) {
        try {
            String path = base.getLocalePath(locale);
            URL url = applicationContext.getResource(path).getURL();
            if (url == null) {
                return null;
            } else {
                return new URLApplicationResource(url.toExternalForm(), url);
            }
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Collection<ApplicationResource> getResources(String path) {
        ArrayList<ApplicationResource> resources = new ArrayList<ApplicationResource>();
        Resource[] foundResources;
        try {
            foundResources = applicationContext.getResources(path);
        } catch (IOException e) {
            return Collections.<ApplicationResource> emptyList();
        }
        for (Resource resource : foundResources) {
            try {
                URL url = resource.getURL();
                resources.add(new URLApplicationResource(url.toExternalForm(), url));
            } catch (IOException e) {
                continue;
            }
        }
        return resources;
    }
}
