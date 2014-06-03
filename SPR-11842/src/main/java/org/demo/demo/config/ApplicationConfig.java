/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.demo.demo.config;

import org.demo.demo.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

/**
 *
 * @author pmr
 */
@Configuration
@ComponentScan("org.demo.demo")
public class ApplicationConfig {
    @Bean
    public HttpInvokerProxyFactoryBean myService() {
        HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
        factory.setServiceUrl("/svc/dummy");
        factory.setServiceInterface(MyService.class);
        return factory;
    }
}
