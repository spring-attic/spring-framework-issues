package com.example.spr15790;

import java.net.URI;

import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

public class TestClientApp {

	public static void main(String[] args) {

		int toBeSent = 2;
		Flux<String> flux = Flux.range(1, toBeSent).map(count -> {
			String result = "{\"content\":" + "\"" + count + "\"}";
			if (count == 1) {
				return "[" + result;
			}
			else if (count == toBeSent) {
				return "," + result + "]";
			}
			else {
				return "," + result;
			}
		});

		EntityExchangeResult<Void> result = WebTestClient.bindToServer().build()
				.post().uri(URI.create("http://localhost:8080/eventSink"))
				.contentType(MediaType.APPLICATION_JSON)
				.body(flux, String.class).exchange()
				.expectStatus().isOk()
				.expectBody().isEmpty();

		System.out.println(result);
	}
}
