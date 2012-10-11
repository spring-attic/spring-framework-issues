package spring.config.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *
 * @author jbaruch
 * @since 10/10/12
 */
@Aspect
@Component
public class CatchAspect {

    private boolean configurationCought;
    private boolean beanCought;

    public boolean isConfigurationCought() {
        return configurationCought;
    }

    public boolean isBeanCought() {
        return beanCought;
    }

    //works - won't match configuration
    @Before("execution(* spring.config.*.*())")
    public void catchBean(){
        beanCought = true;
    }

    @Before("execution(* spring.config.application.*.*())")
    public void catchConfiguration(){
        configurationCought = true;
    }
}
