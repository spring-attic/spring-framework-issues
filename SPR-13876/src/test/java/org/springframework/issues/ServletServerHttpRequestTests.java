package org.springframework.issues;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ServletServerHttpRequestTests {

    private ServletServerHttpRequest request;

    private MockHttpServletRequest mockRequest;

    @Before
    public void create() throws Exception {
        mockRequest = new MockHttpServletRequest();
        request = new ServletServerHttpRequest(mockRequest);
    }

    @Test
    public void getURI() throws Exception {
        URI uri = new URI("https://example.com/%E4%B8%AD%E6%96%87?redirect=https%3A%2F%2Fgithub.com%2Fspring-projects%2Fspring-framework");
        mockRequest.setScheme(uri.getScheme());
        mockRequest.setServerName(uri.getHost());
        mockRequest.setServerPort(uri.getPort());
        // NOTE: should use getRawPath() instead of getPath() is decoded, while HttpServletRequest.setRequestURI() is encoded
        mockRequest.setRequestURI(uri.getRawPath());
        // NOTE: should use getRawQuery() instead of getQuery() is decoded, while HttpServletRequest.getQueryString() is encoded
        mockRequest.setQueryString(uri.getRawQuery());
        assertEquals("Invalid uri", uri, request.getURI());
    }
}
