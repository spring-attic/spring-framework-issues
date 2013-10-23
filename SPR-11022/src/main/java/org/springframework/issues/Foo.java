package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;

public class Foo {

	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
	}
}