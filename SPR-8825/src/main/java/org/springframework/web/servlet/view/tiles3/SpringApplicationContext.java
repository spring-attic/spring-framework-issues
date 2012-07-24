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
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.locale.URLApplicationResource;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ServletContextAware;

/**
 * An {@link org.apache.tiles.request.ApplicationContext} based on Spring's {@link ApplicationContext}.
 *
 * @author Nicolas Le Bas
 * @author mick semb wever
 */
public class SpringApplicationContext implements org.apache.tiles.request.ApplicationContext, ApplicationContextAware, ServletContextAware {

    private ApplicationContext applicationContext;
    private ServletApplicationContext delegate;

    @Override
    public ServletContext getContext() {
        return (ServletContext) delegate.getContext();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        delegate = new ServletApplicationContext(servletContext);
    }

    @Override
    public Map<String, Object> getApplicationScope() {
        return delegate.getApplicationScope();
    }

    @Override
    public Map<String, String> getInitParams() {
        return delegate.getInitParams();
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
