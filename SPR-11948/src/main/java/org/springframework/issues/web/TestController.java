package org.springframework.issues.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/")
	@ResponseBody
	public User showUser() {
		return new User("test");
	}
}
