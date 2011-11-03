package org.springframework.issues;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("myInterceptor")
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke( MethodInvocation mi ) throws Throwable{
        return mi.proceed();
    }

}