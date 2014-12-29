package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.web.client.RestTemplate;

public class RestTemplateTests {

	@Test
	public void testNoContentLength() throws Exception {

		RestTemplate template = new RestTemplate();
		User user = template.getForObject("http://localhost:8080/SPR-8016/user", User.class);
		Assert.assertNotNull(user);

	}
}
