package com.example.spr15790;

import java.net.URI;

import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class ClientApp {

	public static void main(String[] args) {
		int toBeSent = 257;
		Flux<SendEvent> flux = Flux.range(1, toBeSent)
				.map(count -> new SendEvent(String.valueOf(count)));

		WebClient client = WebClient.create();
		ClientResponse result = client.post().uri(URI.create("http://localhost:8080/eventSink"))
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.body(flux, SendEvent.class)
				.exchange()
				.block();

		System.err.println(result.statusCode());
	}

}
