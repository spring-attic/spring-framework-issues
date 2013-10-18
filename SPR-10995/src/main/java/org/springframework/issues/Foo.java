package org.springframework.issues;

public abstract class Foo {

	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
}