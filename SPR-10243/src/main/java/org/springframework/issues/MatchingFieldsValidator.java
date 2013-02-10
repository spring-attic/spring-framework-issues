
package org.springframework.issues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.ObjectUtils;

public class MatchingFieldsValidator implements
		ConstraintValidator<MatchingFields, Object> {

	private String field;

	private String confirmField;

	public MatchingFieldsValidator() {
		super();
	}

	public void initialize(final MatchingFields annotation) {
		this.field = annotation.field();
		this.confirmField = annotation.confirmField();
	}

	public boolean isValid(final Object object, final ConstraintValidatorContext context) {

		BeanWrapper bean = PropertyAccessorFactory.forBeanPropertyAccess(object);
		boolean valid = ObjectUtils.nullSafeEquals(bean.getPropertyValue(this.field),
				bean.getPropertyValue(this.confirmField));
		if (!valid) {
			context.buildConstraintViolationWithTemplate(
					context.getDefaultConstraintMessageTemplate()
			).addNode(this.field).addConstraintViolation().disableDefaultConstraintViolation();
		}
		return valid;
	}

}
