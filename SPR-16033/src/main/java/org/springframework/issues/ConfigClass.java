package org.springframework.issues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClass {
	@Bean
	public IDummy bean1() {
		return new Dummy();
	}

	@Bean
	public IDummy bean2() {
		return new Dummy();
	}

	@Bean
	public IDummy bean3() {
		return new Dummy();
	}

	@Bean
	public IDummy bean4() {
		return null;
	}
}
