/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.issues;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class BeanValidationTest {

    private static ApplicationContext applicationContext;

    private static XmlWebApplicationContext webApplicationContext;
    
    @BeforeClass
    public static void initialize() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/resource-bundle.xml");
        assertNotNull(applicationContext);
        
        webApplicationContext = new XmlWebApplicationContext();
        webApplicationContext.setConfigLocation("file:src/main/webapp/WEB-INF/spring/*-context.xml");
        webApplicationContext.refresh();
        assertNotNull(webApplicationContext);
    }

    @Test
    public void testApplicationContext() {
        LocalValidatorFactoryBean factory = applicationContext.getBean("validator", LocalValidatorFactoryBean.class);
        Validator validator = factory.getValidator();
        Registration registration = new Registration();
        Set<ConstraintViolation<Registration>> violations = validator.validate(registration);
        assertEquals("ABN is required.", violations.iterator().next().getMessage());
    }

    @Test
    public void testWebApplicationContext() {
        LocalValidatorFactoryBean factory = webApplicationContext.getBean("validator", LocalValidatorFactoryBean.class);
        Validator validator = factory.getValidator();
        Registration registration = new Registration();
        Set<ConstraintViolation<Registration>> violations = validator.validate(registration);
        assertEquals("ABN is required.", violations.iterator().next().getMessage());
    }
    
}