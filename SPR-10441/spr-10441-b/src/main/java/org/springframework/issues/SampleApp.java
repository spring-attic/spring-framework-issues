package org.springframework.issues;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author Stephane Nicoll
 */
public class SampleApp {

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@Import(Config.class)
	public static class AppConfig {

	}
}
