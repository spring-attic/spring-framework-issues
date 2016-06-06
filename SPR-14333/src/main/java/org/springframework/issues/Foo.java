package org.springframework.issues;

import org.springframework.beans.factory.annotation.Lookup;

public class Foo {

	public Foo() {
	}

	@Lookup
	public Bar getBar() {
		throw new IllegalStateException("@Lookup method should be overriden by Spring");
	}
}
