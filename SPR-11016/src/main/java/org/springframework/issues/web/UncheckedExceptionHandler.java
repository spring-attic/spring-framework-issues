package org.springframework.issues.web;

import org.springframework.issues.exceptions.UncheckedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UncheckedExceptionHandler {
	public static final String RESPONSE = "unchecked";
	
	@ExceptionHandler(UncheckedException.class)
	public @ResponseBody String handle(UncheckedException e) {
		return RESPONSE;
	}

}
