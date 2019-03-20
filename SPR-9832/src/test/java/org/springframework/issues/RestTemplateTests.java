package org.springframework.issues;

import static org.junit.Assert.assertEquals;

import org.apache.commons.httpclient.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTests {

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        HttpClient httpClient = new HttpClient();
		this.restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory(httpClient));
    }

    @Test
    public void google() {
        String url = "https://www.google.com/ig/calculator?q=1USD=?EUR";
		String response = this.restTemplate.getForObject(url, String.class);

        assertEquals("{lhs: \"1 U.S. dollar\",rhs: \"1 U.S. dollar\",error: \"\",icc: true}", response);
    }

    @Test
    public void localhost() {
        String url = "http://localhost:8080/SPR-9832/calculator";
		String response = this.restTemplate.getForObject(url, String.class);

		assertEquals("{lhs: \"1 U.S. dollar\",rhs: \"1 U.S. dollar\",error: \"\",icc: true}", response);
    }

}
