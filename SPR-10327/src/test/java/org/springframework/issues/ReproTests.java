package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import t.A;

public class ReproTests {

	@Test
	public void repro() {
		// does not throw the exception reported in SPR-10327
		new AnnotationConfigApplicationContext(A.class);
	}

}
