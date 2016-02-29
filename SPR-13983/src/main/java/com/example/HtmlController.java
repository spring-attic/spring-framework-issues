package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

	@RequestMapping(value = "/html/test")
	public ModelAndView test1() {
		return new ModelAndView("test");
	}

}
