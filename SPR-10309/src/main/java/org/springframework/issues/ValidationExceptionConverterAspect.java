
package org.springframework.issues;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class ValidationExceptionConverterAspect {

	@Pointcut("@within(org.springframework.validation.annotation.Validated)")
	protected void validated() {

	}

	@AfterThrowing(value = "validated()", throwing = "t")
	public void invoke(Throwable t) throws ValidationException {
		if (t instanceof MethodConstraintViolationException) {
			MethodConstraintViolationException methodConstraintViolationException = (MethodConstraintViolationException) t;
			throw new ValidationException(methodConstraintViolationException);
		}

	}

}
