package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.issues.supportingclasses.TestHandlerInterceptor;
import org.springframework.issues.supportingclasses.TestHandlerMethodReturnValueHandler;
import org.springframework.issues.supportingclasses.TestWebArgumentResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class DelegatingWebMvcConfigurationWithOtherAutowiredDependenciesTests {

    @Autowired
    ApplicationContext context;

    @Configuration
    @EnableWebMvc
    static class Config {

        @Bean
        TestWebMvcConfigurer testWebMvcConfigurerWithContentNegotiationManager() {
            return new TestWebMvcConfigurer() {
                @Autowired
                ApplicationContext context;

                @Autowired @Lazy
                private ContentNegotiationManager contentNegotiationManager;

                @Autowired @Lazy
                private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

                @Autowired @Lazy
                private HandlerExceptionResolver handlerExceptionResolver;

                @Autowired(required = false)
                private List<HttpMessageConverter<?>> httpMessageConverters;

                private final HandlerMethodArgumentResolver testWebArgumentResolver = new ServletWebArgumentResolverAdapter(new TestWebArgumentResolver());

                /**
                 * Using @Lazy initialization in the autowired dependencies above, this test
                 * looks to make sure all of the following methods get called.
                 */

                @Override
                public void addInterceptors(InterceptorRegistry interceptorRegistry) {
                    interceptorRegistry.addInterceptor(new TestHandlerInterceptor());
                    super.addInterceptors(interceptorRegistry);
                }

                @Override
                public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
                    list.add(this.testWebArgumentResolver);
                    super.addArgumentResolvers(list);
                }

                @Override
                public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
                    contentNegotiationConfigurer.defaultContentType(MediaType.APPLICATION_JSON);
                    super.configureContentNegotiation(contentNegotiationConfigurer);
                }

                @PostConstruct
                public void testPostConstruct() {
                    org.springframework.util.Assert.notNull(this.context, "context may not be null");
                    org.springframework.util.Assert.notNull(this.contentNegotiationManager, "contentNegotiationManager may not be null");
                    org.springframework.util.Assert.notNull(this.requestMappingHandlerAdapter, "requestMappingHandlerAdapter may not be null");
                    org.springframework.util.Assert.notNull(this.handlerExceptionResolver, "handlerExceptionResolver may not be null");

                    if (this.httpMessageConverters == null) {
                        //For Non-Spring Boot Applications
                        this.httpMessageConverters = this.requestMappingHandlerAdapter.getMessageConverters();
                    }
                    org.springframework.util.Assert.notNull(httpMessageConverters, "httpMessageConverters may not be null");

                    //Add test returnValueHandler
                    final TestHandlerMethodReturnValueHandler testHandlerMethodReturnValueHandler = new TestHandlerMethodReturnValueHandler(httpMessageConverters, contentNegotiationManager);
                    final List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>(this.requestMappingHandlerAdapter.getReturnValueHandlers());
                    handlers.add(0, testHandlerMethodReturnValueHandler);
                    this.requestMappingHandlerAdapter.setReturnValueHandlers(handlers);

                    //Add test handlerExceptionResolver
                    ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver = new ExceptionHandlerExceptionResolver();
                    exceptionHandlerExceptionResolver.setApplicationContext(this.context);
                    exceptionHandlerExceptionResolver.setContentNegotiationManager(this.contentNegotiationManager);
                    exceptionHandlerExceptionResolver.setCustomReturnValueHandlers(new ArrayList<HandlerMethodReturnValueHandler>() {{add(testHandlerMethodReturnValueHandler);}});
                    exceptionHandlerExceptionResolver.setMessageConverters(httpMessageConverters);
                    exceptionHandlerExceptionResolver.setCustomArgumentResolvers(new ArrayList<HandlerMethodArgumentResolver>() {{
                        add(testWebArgumentResolver);
                    }});
                    exceptionHandlerExceptionResolver.afterPropertiesSet();

                    HandlerExceptionResolverComposite handlerExceptionResolverComposite = (HandlerExceptionResolverComposite)this.handlerExceptionResolver;
                    final List<HandlerExceptionResolver> exceptionResolvers = new ArrayList<HandlerExceptionResolver>(handlerExceptionResolverComposite.getExceptionResolvers());
                    exceptionResolvers.add(0, exceptionHandlerExceptionResolver);
                    handlerExceptionResolverComposite.setExceptionResolvers(exceptionResolvers);
                }
            };
        }
    }

    @Test
    public void testThatAllMethodsOnTestWebMvcConfigurerGotCalled() {
        TestWebMvcConfigurer testWebMvcConfigurer = context.getBean(TestWebMvcConfigurer.class);
        Assert.assertNotNull(testWebMvcConfigurer);
        Assert.assertEquals(testWebMvcConfigurer.getCallbackMethodsThatWereNotCalled(), TestWebMvcConfigurer.CALLBACK_METHOD_COUNT, testWebMvcConfigurer.getCounterValue());
    }

}
