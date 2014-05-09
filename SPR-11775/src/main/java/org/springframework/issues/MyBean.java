package org.springframework.issues;

import javax.validation.constraints.NotNull;

public class MyBean {

	@NotNull
	private String value;

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
}
