package org.springframework.issues;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TestController {

	@RequestMapping("/foo")
	public void handle() {
		throw new IllegalArgumentException("Error from TestController");
	}

	@RequestMapping("/error")
	public void handleError() {
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Missing input")
	public void handleException() {
	}

}
