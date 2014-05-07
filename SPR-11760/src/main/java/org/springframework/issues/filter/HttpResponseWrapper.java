package org.springframework.issues.filter;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ResizableByteArrayOutputStream;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class HttpResponseWrapper extends HttpServletResponseWrapper {

    private static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";

    private final ResizableByteArrayOutputStream content;
    private final ServletOutputStream outputStream;
    private final HttpServletResponse originalHttpServletResponse;
    private PrintWriter writer;

    public HttpResponseWrapper(HttpServletResponse originalHttpServletResponse) {
        super(originalHttpServletResponse);
        this.content = new ResizableByteArrayOutputStream();
        this.outputStream = new ResponseServletOutputStream();
        this.originalHttpServletResponse = originalHttpServletResponse;
    }

    public void flushContent() throws IOException {
        byte[] body = content.toByteArray();
        if (body.length > 0) {
            originalHttpServletResponse.setContentLength(body.length);
            StreamUtils.copy(body, originalHttpServletResponse.getOutputStream());
        }
    }

    public String getResponseBody() throws IOException {
        return new String(content.toByteArray(), getCharacterEncoding());
    }

    public HttpHeaders getResponseHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        for (String headerName : getHeaderNames()) {
            for (String headerValue : getHeaders(headerName)) {
                responseHeaders.add(headerName, headerValue);
            }
        }
        return responseHeaders;
    }

    @Override
    public String getCharacterEncoding() {
        String characterEncoding = super.getCharacterEncoding();
        return characterEncoding != null ? characterEncoding : DEFAULT_CHARACTER_ENCODING;
    }

    @Override
    public void setContentLength(int len) {
        this.content.resize(len);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (this.writer == null) {
            this.writer = new ResponsePrintWriter(getCharacterEncoding());
        }
        return this.writer;
    }

    @Override
    public void reset() {
        super.reset();
        resetBuffer();
    }

    @Override
    public void resetBuffer() {
        this.content.reset();
    }

    private class ResponseServletOutputStream extends ServletOutputStream {

        @Override
        public void write(int b) throws IOException {
            content.write(b);
        }

        @Override
        public void write(@NotNull byte[] b, int off, int len) throws IOException {
            content.write(b, off, len);
        }
    }

    private class ResponsePrintWriter extends PrintWriter {

        private ResponsePrintWriter(String characterEncoding) throws IOException {
            super(new OutputStreamWriter(content, characterEncoding));
        }

        @Override
        public void write(@NotNull char[] buf, int off, int len) {
            super.write(buf, off, len);
            super.flush();
        }

        @Override
        public void write(@NotNull String str, int off, int len) {
            super.write(str, off, len);
            super.flush();
        }

        @Override
        public void write(int c) {
            super.write(c);
            super.flush();
        }
    }
}
