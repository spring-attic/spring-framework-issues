package com.example;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	public void configureTestProperties(TestProperties properties) {
		Stream.of(properties.getResources()).forEach(resource -> {
			try {
				System.out.println(resource.getURL());
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@Component
	@ConfigurationProperties(prefix = "my.app.test")
	public static class TestProperties {

		private Resource[] resources;

		public Resource[] getResources() {
			return resources;
		}

		public void setResources(Resource[] resources) {
			this.resources = resources;
		}
	}
}