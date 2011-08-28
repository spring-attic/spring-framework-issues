package org.springframework.samples.config.basic.account;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.google.gson.GsonBuilder;

@Configurable
public class AppConfig {

	@Bean(name = "gsonBuilder")
	public GsonBuilder gsonBuilder() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		return gsonBuilder;
	}

}
