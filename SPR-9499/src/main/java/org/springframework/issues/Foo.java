package org.springframework.issues;

import org.springframework.util.MultiValueMap;

public class Foo {

	private final MultiValueMap<String,String> parameters;

	public Foo(MultiValueMap<String,String> parameters) {
		this.parameters = parameters;
	}

	public MultiValueMap<String, String> getParameters() {
		return parameters;
	}
}
