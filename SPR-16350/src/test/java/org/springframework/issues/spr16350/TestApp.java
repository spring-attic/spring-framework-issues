package org.springframework.issues.spr16350;

import java.io.ByteArrayOutputStream;

import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.Part;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

public class TestApp {

	public static void main(String[] args) {

		MultiValueMap<String, Object> multipartData = new LinkedMultiValueMap<>();
		multipartData.add("file", new byte[] { 'a', 'b', 'c', 'd' });
		WebTestClient.bindToRouterFunction(RouterFunctions.route(POST("/foo"), (req) ->
			req.body(BodyExtractors.toMultipartData())
					.flatMap(parts -> {
						Part filePart = parts.getFirst("file");
						ByteArrayOutputStream contentStream = new ByteArrayOutputStream();
						DataBufferUtils.write(filePart.content(), contentStream).blockFirst();
						System.out.println(new String(contentStream.toByteArray()));
						System.out.println(filePart.headers());
						return ServerResponse.accepted().build();
					})
		)).configureClient().baseUrl("http://localhost").build().post().uri("/foo")
				.body(BodyInserters.fromMultipartData(multipartData)).exchange()
				.expectBody().returnResult();
	}

}
