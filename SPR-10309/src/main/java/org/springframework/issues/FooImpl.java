
package org.springframework.issues;

import org.hibernate.validator.internal.engine.MethodConstraintViolationImpl;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;

@Component
@Validated
public class FooImpl implements Foo {

	@Override
	public void bar(String s) throws ValidationException {
		System.out.println("s = " + s);
	}

	@Override
	public void bar() throws ValidationException {
		throw new MethodConstraintViolationException(
				Collections.singleton(new MethodConstraintViolationImpl<MethodConstraintViolation<?>>(
						null, null, null, null, null, null, null, null, null, null, null,
						null)));
	}

}
