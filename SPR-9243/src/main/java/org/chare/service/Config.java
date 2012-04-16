package org.chare.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class Config {
	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserPreferences userPreferences() {
		return new UserPreferences();
	}

	@Bean
	public Service Service() {
		return new Service();
	}

}
