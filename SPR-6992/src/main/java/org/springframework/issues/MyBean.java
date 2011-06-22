package org.springframework.issues;

import org.springframework.scheduling.annotation.Async;

public class MyBean {

	private String test;

	@Async
	public void test() {

	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
