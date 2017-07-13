package com.example.demo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class SessionApplication {

	@SessionScope
	@Bean
	public Foo foo() {
		return new Foo();
	}

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}
}

@RestController
class HomeController {

	@Autowired
	private Foo foo;

	@GetMapping("/")
	public String home() {
		Foo foo = (Foo) SerializationUtils
				.deserialize(SerializationUtils.serialize(this.foo));
		return foo.getValue();
	}

}

@SuppressWarnings("serial")
class Foo implements Serializable {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}