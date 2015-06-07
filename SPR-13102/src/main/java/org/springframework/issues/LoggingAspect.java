package org.springframework.issues;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("@args(org.springframework.issues.Loggable))")
    public void loggingBeginByAtArgs() {
        System.out.println("★★★start by @args★★★★");
    }

}
