
package org.springframework.issues;

import org.hibernate.validator.method.MethodConstraintViolationException;

public class ValidationException extends Exception {

	public ValidationException(MethodConstraintViolationException cause) {
		super(cause);
	}
}
