package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@RequestMapping("/")
	public String root(HttpServletRequest request) {

		return String.format("mapping: /, context: %s, servlet: %s, request: %s, pathinfo: %s",
				request.getContextPath(), request.getServletPath(), request.getRequestURI(), request.getPathInfo());
	}
}
