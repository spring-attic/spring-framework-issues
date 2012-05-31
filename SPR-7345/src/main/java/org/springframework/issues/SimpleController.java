package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {

	@RequestMapping(value="/simple/textonly", method=RequestMethod.GET, headers="Accept=text/plain")
	public @ResponseBody String simple() {
		return "Hello world!";
	}
	
}
