/*
 * Copyright 2002-2010 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.springframework.web.servlet.view.tiles3;

import javax.servlet.ServletContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.impl.BasicTilesContainer;
import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.wildcard.WildcardServletApplicationContext;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;

/**
 * @author Nicolas Le Bas
 * */
public class TilesConfigurerTests {

    @Configuration
    public static class AppConfig {
        @Bean
        public ServletApplicationContext applicationContext(ServletContext servletContext) {
            return new WildcardServletApplicationContext(servletContext);
        }

        @Bean
        public ServletContext servletContext() {
            return new MockServletContext();
        }
    }

    @Test
    public void simpleBootstrap() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ServletContext sc = ctx.getBean(ServletContext.class);
        TilesConfigurer tc = new TilesConfigurer();
        tc.setApplicationContext(ctx);
        tc.setDefinitions(new String[] { "/org/springframework/web/servlet/view/tiles3/tiles-definitions.xml" });
        tc.setCheckRefresh(true);
        tc.setServletContext(sc);
        tc.afterPropertiesSet();

        BasicTilesContainer container = (BasicTilesContainer) TilesAccess.getContainer(ctx.getBean(ServletApplicationContext.class));
        Request requestContext = new ServletRequest(container.getApplicationContext(),
                                                    new MockHttpServletRequest(),
                                                    new MockHttpServletResponse());
        assertNotNull(container.getDefinitionsFactory().getDefinition("test", requestContext));

        tc.destroy();
    }

}
