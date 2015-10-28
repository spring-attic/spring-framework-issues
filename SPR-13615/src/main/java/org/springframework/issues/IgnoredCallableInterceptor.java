package org.springframework.issues;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

public class IgnoredCallableInterceptor extends CallableProcessingInterceptorAdapter {

    AtomicBoolean executed = new AtomicBoolean(false);

    @Override
    public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
        executed.set(true);
    }
}
