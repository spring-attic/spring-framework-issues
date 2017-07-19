package com.example.spr15790;

import java.net.URI;

import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

public class TestClientApp {

	public static void main(String[] args) {

		int toBeSent = 2;
		Flux<String> flux = Flux.range(1, toBeSent).map(count -> "{\"content\":" + "\"" + count + "\"}");

		EntityExchangeResult<Void> result = WebTestClient.bindToServer().build()
				.post().uri(URI.create("http://localhost:8080/eventSink"))
				.contentType(MediaType.parseMediaType("application/stream+json;charset=UTF-8"))
				.body(flux, String.class).exchange()
				.expectStatus().isOk()
				.expectBody().isEmpty();

		System.out.println(result);
	}
}
