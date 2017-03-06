package org.springframework.issues.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 3000)
public class ProtectAnnotationAspect {

    private final Logger logger = LoggerFactory.getLogger(ProtectAnnotationAspect.class);
    private int          called = 0;

    // Have to specify fully qualified name
    @Before("execution(@com.mycompany.spring.aop.aspect.annotation.Protect * *(..))")
    public void protect(final JoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().getName();
        logger.info("Entering protect" + methodInformation);
        called++;
        try {
        } catch (Throwable ex) {
            logger.error("Exception in protect" + methodInformation, ex);
            throw ex;
        } finally {
            logger.info("Exiting protect " + methodInformation);
        }
    }

    public void resetCalled() {
        called = 0;
    }

    public int getCalled() {
        return called;
    }
}
