package org.springframework.issues.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.FooService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	public static final String PATH = "/foo";
	@Autowired
	private FooService service;
	
	
	@RequestMapping(PATH)
	public @ResponseBody String getFoo() throws Throwable { 
		return service.get();
	}
}
