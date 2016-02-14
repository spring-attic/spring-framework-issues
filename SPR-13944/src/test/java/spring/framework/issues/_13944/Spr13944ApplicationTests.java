package spring.framework.issues._13944;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Spr13944Application.class)
@WebAppConfiguration
@IntegrationTest
public class Spr13944ApplicationTests {

	private String goodUrl = "http://localhost:8080/greeting";
	private String badUrl = "http://localhost:8080/greetings";
	
	private RestTemplate restTemplate = new TestRestTemplate();
	
	private void requestToCorrectUrlIsOk(HttpMethod httpMethod) {
		ResponseEntity<String> response = restTemplate.exchange(goodUrl, httpMethod, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	private void requestToMistypedUrlIsNotFound(HttpMethod httpMethod) {
		ResponseEntity<String> response = restTemplate.exchange(badUrl, httpMethod, null, String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	public void testGetForCorrectUrlIsOk() {
		requestToCorrectUrlIsOk(HttpMethod.GET);
	}

	@Test
	public void testGetForMistypedUrl() { 
		requestToMistypedUrlIsNotFound(HttpMethod.GET);
	}

	@Test
	public void testHeadForCorrectUrlIsOk() { 
		requestToCorrectUrlIsOk(HttpMethod.HEAD);
	}

	@Test
	public void testHeadForMistypedUrl() { 
		requestToMistypedUrlIsNotFound(HttpMethod.HEAD);
	}

	@Test
	public void testPostForCorrectUrlIsOk() {
		requestToCorrectUrlIsOk(HttpMethod.POST);
	}

	@Test
	public void testPostForMistypedUrl() {
		// This fails with HttpStatus.METHOD_NOT_ALLOWED
		requestToMistypedUrlIsNotFound(HttpMethod.POST);
	}

	@Test
	public void testPutForCorrectUrlIsOk() {
		requestToCorrectUrlIsOk(HttpMethod.PUT);
	}

	@Test
	public void testPutForMistypedUrl() {
		// This fails with HttpStatus.METHOD_NOT_ALLOWED
		requestToMistypedUrlIsNotFound(HttpMethod.PUT);
	}

	@Test
	public void testDeleteForCorrectUrlIsOk() {
		requestToCorrectUrlIsOk(HttpMethod.DELETE);
	}

	@Test
	public void testDeleteForMistypedUrl() {
		// This fails with HttpStatus.METHOD_NOT_ALLOWED
		requestToMistypedUrlIsNotFound(HttpMethod.DELETE);
	}

	@Test
	public void testOptionsForCorrectUrlIsOk() {
		requestToCorrectUrlIsOk(HttpMethod.OPTIONS);
	}

	@Test
	public void testOptionsForMistypedUrl() {
		// This fails with HttpStatus.OK - maybe OK is always the correct status for OPTIONS?
		requestToMistypedUrlIsNotFound(HttpMethod.OPTIONS);
	}

}
