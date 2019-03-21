/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.example.url.redirect;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ServletForwardingController;

@SpringBootApplication
@Configuration
public class MyServletInitializer {

    @Autowired
    private WebApplicationContext context;

    private static final String MY_SERVLET = "my-servlet";

    public static void main(String[] args) {
        SpringApplication.run(MyServletInitializer.class, args);
    }

    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() {
        ServletRegistrationBean<MyServlet> registration = new ServletRegistrationBean<>(
                new MyServlet(), "/myServlet/*");
        registration.setName(MY_SERVLET);
        return registration;
    }

    @Bean
    public SimpleUrlHandlerMapping vaadinRootMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.LOWEST_PRECEDENCE - 1);

        mapping.setUrlMap(
                Collections.singletonMap("/*", vaadinForwardingController()));

        return mapping;
    }

    @Bean
    public Controller vaadinForwardingController() {
        ServletForwardingController controller = new ServletForwardingController();
        controller.setServletName(MY_SERVLET);
        return controller;
    }

//    @Bean
//    @ConditionalOnMissingClass("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean")
//    public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistration() {
//        DispatcherServlet servlet = context.getBean(DispatcherServlet.class);
//        ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(servlet, "/*");
//        registration.setName("dispatcher");
//        return registration;
//    }
}