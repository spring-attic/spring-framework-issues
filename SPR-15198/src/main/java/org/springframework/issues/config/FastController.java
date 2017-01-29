package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FastController {


	// This preparation works fast
	@ModelAttribute
	public void before(Model test) {
		TestClass t = new TestClass("fast");
		test.addAttribute("test", t);
	}
	
	
	@RequestMapping(value={"/fast1", "/fast2", "/fast3"})
	public @ResponseBody String test1(@ModelAttribute(name="test") TestClass test) {
		return test.getPayload();
	}
	


}
