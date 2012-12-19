package com.xyz;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author borisb
 */
public class TestAspect {

    private static final Logger log = Logger.getLogger(TestAspect.class);

    public Object invokeNew(ProceedingJoinPoint pjp) throws Throwable {
        log.info("aspect invoked");
        doWork();
        return pjp.proceed();
    }

    public Object invokeOld(ProceedingJoinPoint pjp) throws Throwable {
        log.info("aspect invoked");
        Field methodInvocationField = MethodInvocationProceedingJoinPoint.class.getDeclaredField("methodInvocation");
        methodInvocationField.setAccessible(true);
        ReflectiveMethodInvocation methodInvocation = (ReflectiveMethodInvocation) methodInvocationField.get(pjp);

        Field methodField = ReflectiveMethodInvocation.class.getDeclaredField("method");
        methodField.setAccessible(true);
        Method method = (Method) methodField.get(methodInvocation);

        Annotation annotation = method.getAnnotation(Secured.class);
        if (annotation != null) {
            log.info("do the aspects work");
            doWork();
        }
        return pjp.proceed();
    }

    private void doWork() throws Exception {
        // throw exception to easy check if aspect invoked
        throw new Exception("aspect invoked");
    }

}
