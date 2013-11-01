package org.springframework.issues.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CatchAllExceptionHandler {
	public static final String RESPONSE = "catchall";
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handle(Exception e) {
		return RESPONSE;
	}

}
