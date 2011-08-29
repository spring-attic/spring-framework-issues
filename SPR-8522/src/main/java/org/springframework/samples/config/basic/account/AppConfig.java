package org.springframework.samples.config.basic.account;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.GsonBuilder;

@Configuration
public class AppConfig {

	@Bean(name = "gsonBuilder")
	public GsonBuilder gsonBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		return gsonBuilder;
	}

}
