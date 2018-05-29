package com.example.demo;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	private ClientAndServer mockServer;
	
	
	@Before
	public void before() throws IOException {

		
		mockServer = startClientAndServer(0);
		mockServer.when(
				request()
					.withMethod("POST")			
					.withPath("/someservice")
					)
			.respond(
					response()
					.withStatusCode(401)
					.withHeaders(
							new Header("Content-Type", "application/json; charset=utf-8")
							)
					.withBody("{\"some\":\"json\"}")
							
					);


	}


	@Test(expected=HttpClientErrorException.class)
	public void error401_withdefaulthandler() {
		RestTemplate rt = restTemplateBuilder
				.errorHandler(new DefaultResponseErrorHandler())
				.build();

		ResponseEntity<Map<String,Object>> response = rt.exchange("http://localhost:" + mockServer.getPort() + "/someservice", 
				HttpMethod.POST,
				new HttpEntity<>(new HashMap<String,Object>()), 
				new ParameterizedTypeReference<Map<String,Object>>(){});
		
		log.info("got response {}", response);
		
		
	}
	

	@Test(expected=HttpClientErrorException.class)
	public void error401_noHandler() {
		RestTemplate rt = restTemplateBuilder
				.build();



		ResponseEntity<Map<String,Object>> response = rt.exchange("http://localhost:" + mockServer.getPort() + "/someservice", 
				HttpMethod.POST,
				new HttpEntity<>(new HashMap<String,Object>()), 
				new ParameterizedTypeReference<Map<String,Object>>(){});
		
		log.info("got response {}", response);
		
		
		
	}



	@Test
	public void error401_withcustomhandler_noerrors() {
		RestTemplate rt = restTemplateBuilder
				.errorHandler(new ResponseErrorHandler(){
					@Override
					public boolean hasError(ClientHttpResponse response) throws IOException {
						return false;
					}
					@Override
					public void handleError(ClientHttpResponse response) throws IOException {
					}})
				.build();

		ResponseEntity<Map<String,Object>> response = rt.exchange("http://localhost:" + mockServer.getPort() + "/someservice", 
				HttpMethod.POST,
				new HttpEntity<>(new HashMap<String,Object>()), 
				new ParameterizedTypeReference<Map<String,Object>>(){});
		
		log.info("got response {}", response);
		
		
	}
	

	@Test(expected=HttpClientErrorException.class)
	public void error401_withcustomhandler_allerrors() {
		RestTemplate rt = restTemplateBuilder
				.errorHandler(new ResponseErrorHandler(){
					@Override
					public boolean hasError(ClientHttpResponse response) throws IOException {
						return true;
					}
					@Override
					public void handleError(ClientHttpResponse response) throws IOException {
						throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "unauthorized");
					}})
				.build();


		ResponseEntity<Map<String,Object>> response = rt.exchange("http://localhost:" + mockServer.getPort() + "/someservice", 
				HttpMethod.POST,
				new HttpEntity<>(new HashMap<String,Object>()), 
				new ParameterizedTypeReference<Map<String,Object>>(){});
		
		log.info("got response {}", response);
		
		
	}
}
