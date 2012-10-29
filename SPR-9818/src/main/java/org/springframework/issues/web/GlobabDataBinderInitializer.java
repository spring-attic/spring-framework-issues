package org.springframework.issues.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobabDataBinderInitializer {

	@InitBinder
	public void initDataBinder(WebDataBinder binder) {
		System.out.println("In GlobabDataBinderInitializer.initDataBinder method");
		binder.setAutoGrowNestedPaths(false);
	}

}
