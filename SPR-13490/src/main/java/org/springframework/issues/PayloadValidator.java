package org.springframework.issues;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PayloadValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Payload.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "message", "empty message");

    }
}
