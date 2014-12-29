package org.springframework.issues;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/user")
	public User getUser() {
		User user = new User("spring", "framework");
		return user;
	}

}
