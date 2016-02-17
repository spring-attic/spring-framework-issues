package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/greeting")
	public String greeting() {
		return "hello";
	}

}
