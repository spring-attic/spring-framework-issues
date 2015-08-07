package org.springframework.issues.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TypeAnnotationPointcutAspect {
    @Pointcut("execution(* (@org.springframework.issues.annotation.Annotation1 !@org.springframework.issues.annotation.Annotation2 *).*(..))")
    private void someAnnotations() {
    }

    @Before("someAnnotations()")
    public void failMethod() {
        throw new IllegalArgumentException("You've been advised");
    }
}
