package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


	@GetMapping("/test")
	public String handle() {
		return "redirect:/newpath?newqp=1";
	}


}
