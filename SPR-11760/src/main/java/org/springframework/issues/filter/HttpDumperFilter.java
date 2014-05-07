package org.springframework.issues.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpDumperFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(HttpDumperFilter.class);
    private static final Logger dumper = LoggerFactory.getLogger("http.dumper");
    private final ObjectWriter objectWriter = new ObjectMapper().writer();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            long processingStarted = System.currentTimeMillis();
            HttpRequestWrapper request = new HttpRequestWrapper(httpServletRequest);
            HttpResponseWrapper response = new HttpResponseWrapper(httpServletResponse);
            filterChain.doFilter(request, response);
            response.flushContent();
            long processingTime = System.currentTimeMillis() - processingStarted;
            HttpDump httpDump = getDump(request, response, processingTime);
            dumper.info("{}", objectWriter.writeValueAsString(httpDump));
        } catch (Exception ex) {
            logger.error("", ex);
            throw ex;
        }
    }

    private HttpDump getDump(HttpRequestWrapper request, HttpResponseWrapper response, long processingTime) throws IOException {
        HttpDump httpDump = new HttpDump();
        httpDump.setProcessingTime(processingTime);
        httpDump.setRequestUri(request.getRequestURI());
        httpDump.setRequestMethod(request.getMethod());
        httpDump.setRequestHeaders(request.getRequestHeaders());
        httpDump.setRequestBody(request.getRequestBody());
        httpDump.setResponseStatus(response.getStatus());
        httpDump.setResponseHeaders(response.getResponseHeaders());
        httpDump.setResponseBody(response.getResponseBody());
        return httpDump;
    }
}
