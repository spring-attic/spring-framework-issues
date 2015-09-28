package example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckBeforeAspect implements Ordered {
	private static final int ORDER = CheckPrecedence.LOWER_PRECEDENCE;

	@Before("execution(@example.annotation.BeforeAnnotation * *(..))")
	public void checkBefore() {
		System.out.println(ORDER + " - checkBefore");

		throw new RuntimeException("checkBefore exception");  
	}

	@Override
	public int getOrder() {
		return ORDER;
	}
	
}
