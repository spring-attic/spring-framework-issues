package org.springframework.issues;

import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple class that counts each WebMvcConfigurer callback method
 * that gets called.  For convenience, the
 * getCallbackMethodsThatWereNotCalled will return a string that
 * lists all of the methods that don't get called
 */
public class TestWebMvcConfigurer implements WebMvcConfigurer {

    private final AtomicInteger counter = new AtomicInteger();
    public static final long CALLBACK_METHOD_COUNT = 16;
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private boolean addFormattersCalled; //1
    private boolean configureMessageConvertersCalled; //2
    private boolean extendMessageConvertersCalled; //3
    private boolean getValidatorCalled; //4
    private boolean configureContentNegotiationCalled; //5
    private boolean configureAsyncSupportCalled; //6
    private boolean configurePathMatchCalled; //7
    private boolean addArgumentResolversCalled; //8
    private boolean addReturnValueHandlersCalled; //9
    private boolean configureHandlerExceptionResolversCalled; //10
    private boolean addInterceptorsCalled; //11
    private boolean getMessageCodesResolverCalled; //12
    private boolean addViewControllersCalled; //13
    private boolean configureViewResolversCalled; //14
    private boolean addResourceHandlersCalled; //15
    private boolean configureDefaultServletHandlingCalled; //16


    public int getCounterValue() {
        return this.counter.get();
    }

    //1
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        this.addFormattersCalled = true;
        this.counter.getAndIncrement();
    }

    //2
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {
        this.configureMessageConvertersCalled = true;
        this.counter.getAndIncrement();
    }

    //3
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {
        this.extendMessageConvertersCalled = true;
        this.counter.getAndIncrement();
    }

    //4
    @Override
    public Validator getValidator() {
        this.getValidatorCalled = true;
        this.counter.getAndIncrement();
        return null;
    }

    //5
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
        this.configureContentNegotiationCalled = true;
        this.counter.getAndIncrement();
    }

    //6
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {
        this.configureAsyncSupportCalled = true;
        this.counter.getAndIncrement();
    }

    //7
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        this.configurePathMatchCalled = true;
        this.counter.getAndIncrement();
    }

    //8
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {
        this.addArgumentResolversCalled = true;
        this.counter.getAndIncrement();
    }

    //9
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {
        this.addReturnValueHandlersCalled = true;
        this.counter.getAndIncrement();
    }

    //10
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {
        this.configureHandlerExceptionResolversCalled = true;
        this.counter.getAndIncrement();
    }

    //11
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        this.addInterceptorsCalled = true;
        this.counter.getAndIncrement();
    }

    //12
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        this.getMessageCodesResolverCalled = true;
        this.counter.getAndIncrement();
        return null;
    }

    //13
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        this.addViewControllersCalled = true;
        this.counter.getAndIncrement();
    }

    //14
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        this.configureViewResolversCalled = true;
        this.counter.getAndIncrement();
    }

    //15
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        this.addResourceHandlersCalled = true;
        this.counter.getAndIncrement();
    }

    //16
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        this.configureDefaultServletHandlingCalled = true;
        this.counter.getAndIncrement();
    }

    /**
     * Returns a list of WebMvcConfigurer callback methods that haven't been called.
     * @return
     */
    public String getCallbackMethodsThatWereNotCalled() {
        StringBuffer sb = new StringBuffer();

        if (this.counter.get() == CALLBACK_METHOD_COUNT) {
            sb.append("All WebMvcConfigurer callback methods have been called.");
        }
        else {
            System.lineSeparator();
            sb.append("PROBLEM: " + this.counter.get() + " of " + CALLBACK_METHOD_COUNT + " WebMvcConfigurer callback methods have been called.  The following methods were not called: " + LINE_SEPARATOR);
        }

        if (!addFormattersCalled) sb.append("    addFormatters" + LINE_SEPARATOR); //1
        if (!configureMessageConvertersCalled) sb.append("    configureMessageConverters" + LINE_SEPARATOR); //2
        if (!extendMessageConvertersCalled) sb.append("    extendMessageConverters" + LINE_SEPARATOR); //3
        if (!getValidatorCalled) sb.append("    getValidator" + LINE_SEPARATOR); //4
        if (!configureContentNegotiationCalled) sb.append("    configureContentNegotiation" + LINE_SEPARATOR); //5
        if (!configureAsyncSupportCalled) sb.append("    configureAsyncSupport" + LINE_SEPARATOR); //6
        if (!configurePathMatchCalled) sb.append("    configurePathMatch" + LINE_SEPARATOR); //7
        if (!addArgumentResolversCalled) sb.append("    addArgumentResolvers" + LINE_SEPARATOR); //8
        if (!addReturnValueHandlersCalled) sb.append("    addReturnValueHandlers" + LINE_SEPARATOR); //9
        if (!configureHandlerExceptionResolversCalled) sb.append("    configureHandlerExceptionResolvers" + LINE_SEPARATOR); //10
        if (!addInterceptorsCalled) sb.append("    addInterceptors" + LINE_SEPARATOR); //11
        if (!getMessageCodesResolverCalled) sb.append("    getMessageCodesResolver" + LINE_SEPARATOR); //12
        if (!addViewControllersCalled) sb.append("    addViewControllers" + LINE_SEPARATOR); //13
        if (!configureViewResolversCalled) sb.append("    configureViewResolvers" + LINE_SEPARATOR); //14
        if (!addResourceHandlersCalled) sb.append("    addResourceHandlers" + LINE_SEPARATOR); //15
        if (!configureDefaultServletHandlingCalled) sb.append("    configureDefaultServletHandling" + LINE_SEPARATOR); //16

        return sb.toString();
    }


}

