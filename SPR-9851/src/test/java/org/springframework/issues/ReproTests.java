package org.springframework.issues;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReproTests {

	public static void main(String[] args) {
		while(true) {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfigClass.class);
			ctx.destroy();
		}
	}

}
