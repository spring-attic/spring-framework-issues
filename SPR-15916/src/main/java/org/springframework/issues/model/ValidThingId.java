package org.springframework.issues.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "[0-9]{3}")
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface ValidThingId {
    String message() default "must be a valid thing id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
