package example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CheckAnotherAfterAspect implements Ordered {
	private static final int ORDER = CheckPrecedence.NORMAL_PRECEDENCE;
	
	@After("execution(@example.annotation.AfterAnnotation * *(..))")
	public void checkAnotherAfter() {
		System.out.println(ORDER + " - checkAnotherAfter");
	}
	
	@Override
	public int getOrder() {
		return ORDER;
	}
	
}
