package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "forward:/home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "spring");
		return "home";
	}

}
