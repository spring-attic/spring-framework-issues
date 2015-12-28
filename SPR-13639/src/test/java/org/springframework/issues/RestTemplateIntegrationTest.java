package org.springframework.issues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * First, run your project with `mvn package cargo:run -DskipTests` then run this test class
 * @author Brian Clozel
 */
public class RestTemplateIntegrationTest {

	RestTemplate template;

	@Before
	public void setup() {
		this.template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	}

	@Test
	public void testEmptyPut() throws Exception {
		this.template.put("http://localhost:8080/SPR-13639/put?id={0}", null, 12);

	}

	@Test
	public void testEmptyPost() throws Exception {
		ResponseEntity<String> response =
				this.template.postForEntity("http://localhost:8080/SPR-13639/post?id={0}", null, String.class, 12);
		Assert.assertEquals("test", response.getBody());
	}
}
