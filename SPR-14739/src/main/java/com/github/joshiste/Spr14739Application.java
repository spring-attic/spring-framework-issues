package com.github.joshiste;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@EnableAutoConfiguration
@Configuration
@RestController
public class Spr14739Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Spr14739Application.class);

	@RequestMapping(path = "/test")
	public SseEmitter getJournalEvents() {
		final SseEmitter emitter = new SseEmitter();
		try {
			emitter.send("This commits the response and now let the request timeout to see the exception.");
		} catch (IOException ex) {
			LOGGER.debug("error sending event", ex);
		}
		return emitter;
	}


	public static void main(String[] args) {
		SpringApplication.run(Spr14739Application.class, args);
	}


}
