package org.springframework.issues;

import java.util.Collections;

import org.junit.Test;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.XmlEventDecoder;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReproTests {
    @Test
    public void reproduce() {
        WebClient webClient = WebClient.create();
        Mono<ClientResponse> response = webClient.get()
                .uri("http://central.maven.org/maven2/com/github/spotbugs/spotbugs/maven-metadata.xml")
                .accept(MediaType.TEXT_XML, MediaType.APPLICATION_XML).exchange();
        response.flatMap(this::fetchResponse).block();
    }

    private Mono<Long> fetchResponse(ClientResponse res) {
        HttpStatus status = res.statusCode();
        if (!status.is2xxSuccessful()) {
            return Mono.error(new IllegalArgumentException("Unexpected status code:" + status.value()));
        }

        Flux<DataBuffer> data = res.body(BodyExtractors.toDataBuffers());
        // XXX -Dio.netty.buffer.bytebuf.checkAccessible=false is necessary, or
        // we face IllegalReferenceCountException(refCnt = 0) in AbstractByteBuf.class
        return new XmlEventDecoder().decode(data, null, null, Collections.emptyMap()).count();
    }
}
