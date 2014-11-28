package org.springframework.issues.config;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public User showUser() {
		User user = new User();
		user.setFirstName("Sherlock");
		user.setLastName("Holmes");
		return user;
	}
}
