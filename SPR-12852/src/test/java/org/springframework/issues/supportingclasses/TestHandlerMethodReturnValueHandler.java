package org.springframework.issues.supportingclasses;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import java.util.List;

public class TestHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    private final HttpEntityMethodProcessor delegate;

    public TestHandlerMethodReturnValueHandler(final List<HttpMessageConverter<?>> messageConverters) {
        this.delegate = new HttpEntityMethodProcessor(messageConverters);
    }

    public TestHandlerMethodReturnValueHandler(final List<HttpMessageConverter<?>> messageConverters,
                                          final ContentNegotiationManager manager) {
        this.delegate = new HttpEntityMethodProcessor(messageConverters, manager);
    }
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return false;
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {

    }
}
