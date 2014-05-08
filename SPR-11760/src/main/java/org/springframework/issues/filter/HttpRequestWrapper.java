package org.springframework.issues.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class HttpRequestWrapper extends HttpServletRequestWrapper {

    private static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";

    private final byte[] content;

    public HttpRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        // workaround for https://jira.spring.io/browse/SPR-11764 bug:
        ServletInputStream servletInputStream = request.getInputStream();
        if (servletInputStream == null) {
            content = new byte[0];
        } else {
            this.content = StreamUtils.copyToByteArray(servletInputStream);
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ByteArrayServletInputStream(content);
    }

    @Override
    public String getCharacterEncoding() {
        String characterEncoding = super.getCharacterEncoding();
        return characterEncoding != null ? characterEncoding : DEFAULT_CHARACTER_ENCODING;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream(), getCharacterEncoding()));
    }

    public String getRequestBody() throws IOException {
        return new String(content, getCharacterEncoding());
    }

    public HttpHeaders getRequestHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        Enumeration<String> headerNames = getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headers = getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                requestHeaders.add(headerName, headerValue);
            }
        }
        return requestHeaders;
    }

    private static class ByteArrayServletInputStream extends ServletInputStream {

        private final ByteArrayInputStream bais;

        private ByteArrayServletInputStream(byte[] content) {
            this.bais = new ByteArrayInputStream(content);
        }

        @Override
        public int read() throws IOException {
            return bais.read();
        }
    }
}
