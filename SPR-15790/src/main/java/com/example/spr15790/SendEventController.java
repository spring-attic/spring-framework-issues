package com.example.spr15790;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEventController {

	@PostMapping(value = "eventSink", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<String>> eventSink(@RequestBody Flux<SendEvent> flux) {
		return flux
				.doOnNext(event -> System.err.println(event.getContent()))
				.then(Mono.just(new ResponseEntity<>(HttpStatus.OK)));
	}

}
