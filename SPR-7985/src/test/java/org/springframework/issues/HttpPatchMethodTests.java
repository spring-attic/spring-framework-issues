package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class HttpPatchMethodTests {

	// With Apache HttpComponents HttpClient 4.1.3 (i.e. lower than 4.2) on the classpath,
	// use of HTTP PATCH should result in exception with helpful message.

	@Test
	public void test() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		try {
			restTemplate.exchange("/someUrl", HttpMethod.PATCH, null, null);
			fail("Expected exception");
		}
		catch (IllegalArgumentException ex) {
			assertEquals("HTTP method PATCH not available before Apache HttpComponents HttpClient 4.2", ex.getMessage());
		}
	}

}
