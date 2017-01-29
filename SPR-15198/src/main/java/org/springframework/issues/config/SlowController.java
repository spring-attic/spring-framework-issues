package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlowController {

	// This preparation works very slow in spring boot 1.4.3 (spring 4.3.5)
	// In spring boot 1.4.4. it is as fast as the FastController
	@ModelAttribute
	public void before(@ModelAttribute(name="test", binding=false) TestClass test) {
	}

	
	@RequestMapping(value={"/slow1", "/slow2", "/slow3"})
	public @ResponseBody String test1(@ModelAttribute(name="test") TestClass test) {
		return test.getPayload();
	}
	


}
