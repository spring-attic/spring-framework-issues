package io.pivotal.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

	@RestController
	public static class DummyController {

		@RequestMapping("/dummy")
		public List<Pojo> dummy() {
			return new ArrayList<>();
		}

	}

	public static class Pojo {

		String test;

		public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}
	}
}
