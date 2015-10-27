package org.springframework.issues;

import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptorAdapter;

public class IgnoredDeferredResultInterceptor extends DeferredResultProcessingInterceptorAdapter {

    AtomicBoolean executed = new AtomicBoolean(false);

    @Override
    public <T> void afterCompletion(NativeWebRequest request, DeferredResult<T> task) throws Exception {
        executed.set(true);
    }
}
