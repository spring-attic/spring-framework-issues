package org.chare.otherService;

import org.chare.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Autowired
	private Service service;

	@Bean
	public OtherService service() {
		return new OtherService(service);
	}

}
