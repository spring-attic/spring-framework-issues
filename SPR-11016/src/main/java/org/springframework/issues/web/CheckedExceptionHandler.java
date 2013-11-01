package org.springframework.issues.web;

import org.springframework.issues.exceptions.CheckedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CheckedExceptionHandler {
	public static final String RESPONSE = "checked";
	
	@ExceptionHandler(CheckedException.class)
	public @ResponseBody String handle(CheckedException e) {
		return RESPONSE;
	}

}
