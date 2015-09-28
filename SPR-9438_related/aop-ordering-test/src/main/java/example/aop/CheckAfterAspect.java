package example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckAfterAspect implements Ordered {
	private static final int ORDER = CheckPrecedence.HIGHER_PRECEDENCE;
	
	@After("execution(@example.annotation.AfterAnnotation * *(..))")
	public void checkAfter() {
		System.out.println(ORDER + " - checkAfter");
	}
	
	@Override
	public int getOrder() {
		return ORDER;
	}
	
}
