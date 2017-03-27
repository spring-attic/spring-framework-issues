package example;

import java.util.concurrent.Future;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class Enhancer {
	
	@Around("execution(* *.getResponse(..))")
	public Future<String> wrap(ProceedingJoinPoint joinPoint) throws Throwable {
		@SuppressWarnings("unchecked")
		Future<String> result = (Future<String>) joinPoint.proceed();
		return new AsyncResult<String>(result.get() + " (enhanced)");
	}

}
