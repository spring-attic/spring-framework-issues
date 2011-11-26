package com.example;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/** Defines the annotation for component scanning as nested class. */
// the test passes if you remove this annotation
@Component
public class WithNestedAnnotation {

	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Component
	public static @interface MyComponent {

		String value() default "";
	} 
}
