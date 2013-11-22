package org.springframework.issues;

import org.springframework.transaction.annotation.Transactional;

public class Foo {

	public static final void thisIsStaticFinalMethod() {
	}
	
	@Transactional
	public void doInTransaction() {
	}
}