package org.springframework.issues;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	Logger LOG = Logger.getLogger(HomeController.class.getName());

	@RequestMapping(value="/common/hello",method=RequestMethod.GET)
	public String sayHello(){
		LOG.info("In sayHello Method of HomeController");
		return "common/hello";
	}
}
