package atannotationbug;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Aspect("perthis(@annotation(atannotationbug.MyAnnotation))")
public class AroundAdvice {

  @Around("@annotation(a)")
  public Object logResult(ProceedingJoinPoint j, MyAnnotation a) throws Throwable {
    return j.proceed();
  }

}
