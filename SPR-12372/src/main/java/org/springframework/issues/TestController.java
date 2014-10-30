package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller/**")
public class TestController {

	@RequestMapping("/test")
	public String hello(HttpServletRequest request) {
		return String.format("mapping: /test, context: %s, servlet: %s, request: %s, pathinfo: %s",
				request.getContextPath(), request.getServletPath(), request.getRequestURI(), request.getPathInfo());
	}
}
