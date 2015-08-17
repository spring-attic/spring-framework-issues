package org.springframework.issues;

public class Foo {

	private final Bar bar;

	public Foo(Bar bar) {
		this.bar = bar;
	}

	public Bar getBar() {
		return this.bar;
	}
}
