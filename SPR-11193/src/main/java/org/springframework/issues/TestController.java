package org.springframework.issues;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@ExceptionHandler(IllegalStateException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(IllegalStateException exception) {
		return exception.getMessage();
	}


	@RequestMapping(value = "/status", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public TestUser created() {
		TestUser user = new TestUser();
		user.setFirstName("spring");
		user.setLastName("framework");
		return user;
	}

	@RequestMapping("/exception")
	public void exception() {
		throw new IllegalStateException("this is my exception");
	}

	class TestUser {

		private String firstName;

		private String lastName;

		public TestUser() {
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
}
