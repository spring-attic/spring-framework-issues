package com.example.spr15790;

import java.net.URI;

import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class ClientApp {

	public static void main(String[] args) {
		int toBeSent = 257;
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

		WebClient client = WebClient.create();
		ClientResponse result = client.post().uri(URI.create("http://localhost:8080/eventSink"))
				.contentType(MediaType.APPLICATION_JSON)
				.body(flux, String.class)
				.exchange()
				.block();

		System.err.println(result.statusCode());
	}

}
