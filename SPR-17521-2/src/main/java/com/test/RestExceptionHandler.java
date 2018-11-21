package com.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Log log = LogFactory.getLog(RestExceptionHandler.class);
	
    @ExceptionHandler(value = { IllegalArgumentException.class })
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
		log.debug(ex.getMessage());
        return handleExceptionInternal(
        	ex,
        	new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
        	new HttpHeaders(),
        	HttpStatus.BAD_REQUEST, request);
    }
}