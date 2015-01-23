package org.springframework.issues.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void handle(@ModelAttribute Form form) {
		logger.info(form.toString());
	}

}
