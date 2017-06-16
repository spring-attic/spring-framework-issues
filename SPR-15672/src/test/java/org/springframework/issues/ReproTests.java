package org.springframework.issues;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.net.URI;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.mock.http.client.MockAsyncClientHttpRequest;
import org.springframework.test.web.client.SimpleRequestExpectationManager;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	private SimpleRequestExpectationManager manager = new SimpleRequestExpectationManager();

	@Test
	public void sequentialRequestsWithDifferentCount() throws Exception {
		this.manager.expectRequest(times(2), requestTo("/foo")).andExpect(method(GET)).andRespond(withSuccess());
		this.manager.expectRequest(once(), requestTo("/bar")).andExpect(method(GET)).andRespond(withSuccess());

		this.manager.validateRequest(createRequest(GET, "/foo"));
		this.manager.validateRequest(createRequest(GET, "/foo"));
		this.manager.validateRequest(createRequest(GET, "/bar"));
	}

	private ClientHttpRequest createRequest(HttpMethod method, String url) {
		return new MockAsyncClientHttpRequest(method, URI.create(url));
	}

}
