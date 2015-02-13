package org.springframework.issues;

import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTests {

	@Test
	public void testGzipResponse() throws Exception {

		String response = new RestTemplate(new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault()))
				.getForObject("http://localhost:8080/SPR-12712/", String.class);

		Assert.assertEquals("Hello World!", response);
	}
}
