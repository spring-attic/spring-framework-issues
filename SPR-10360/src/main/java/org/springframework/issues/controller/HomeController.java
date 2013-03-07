package org.springframework.issues.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/parent";
	}

	@RequestMapping(value = "/parent", method = RequestMethod.GET)
	public String parent(Model model) {
		model.addAttribute("variableA", "value" );
		model.addAttribute("variableB", "value" );

		return "parent";
	}

	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public String child(Model model) {
		model.addAttribute("variableA", "importedValue");
		model.addAttribute("variableB", null);

		return "child";
	}
}
