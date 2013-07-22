package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {

	private final Bar bar;

	@Autowired
	public Foo(Bar bar) {
		this.bar = bar;
	}

	public Bar getBar() {
		return this.bar;
	}
}
