package com.repro;

import static org.junit.Assert.*;
import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.*;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AsyncrestremplatebugApplication.class)
@WebIntegrationTest("server.port=8080")
public class AsyncrestremplatebugApplicationTests {

    // exception is thrown
	@Test(expected=SystemException.class)
	public void works() throws Exception {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String authHeader = "Basic " + Base64.getEncoder().encode(("user:secret").getBytes());
        headers.add(AUTHORIZATION, authHeader);
        ListenableFuture<ResponseEntity<String>> future =
            asyncRestTemplate.exchange("http://localhost:8080/sleepingendpoint", GET, new HttpEntity<String>(headers), String.class);
        // NOTE - only difference is that this sleeps
        Thread.sleep(5000);
        future.addCallback(s -> {}, f -> {
            System.err.println("CALLED ERROR HANDLER");
            throw new SystemException(f);	// <-- this fails in the test thread
        });
        // the below is never reached
        ResponseEntity<String> resp = future.get();
        assertTrue(resp.getStatusCode().is2xxSuccessful());
	}

    // exception is not thrown
	@Test(expected=SystemException.class)
	public void bug() throws Exception {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String authHeader = "Basic " + new String(Base64.getEncoder().encode(("user:secret").getBytes()));
        headers.add(AUTHORIZATION, authHeader);
        ListenableFuture<ResponseEntity<String>> future =
            asyncRestTemplate.exchange("http://localhost:8080/sleepingendpoint", GET, new HttpEntity<String>(headers), String.class);
        future.addCallback(s -> {}, f -> {
            System.err.println("BUG -> SystemException not propaging up the chain <- BUG");
            throw new SystemException(f);	// <-- this fails in executor thread
        });
        ResponseEntity<String> resp = future.get();	// <-- this fails with ExecutionException
        assertTrue(resp.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testRestTemplate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String authHeader = "Basic " + new String(Base64.getEncoder().encode(("user:password").getBytes()));
        headers.add(AUTHORIZATION, authHeader);
        ResponseEntity<String> resp =
            restTemplate.exchange("http://localhost:8080/sleepingendpoint", GET, new HttpEntity<String>(headers), String.class);
        assertTrue(resp.getStatusCode().is2xxSuccessful());
	}

}
