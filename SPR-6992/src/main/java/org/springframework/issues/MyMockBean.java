package org.springframework.issues;

import org.springframework.beans.factory.InitializingBean;

public class MyMockBean extends MyBean implements InitializingBean {

	private String mock;

	public String getMock() {
		return mock;
	}

	public void setMock(String mock) {
		this.mock = mock;
	}

	public void afterPropertiesSet() throws Exception {

	}

}
