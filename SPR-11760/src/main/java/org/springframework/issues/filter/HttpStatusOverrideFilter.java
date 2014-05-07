package org.springframework.issues.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class HttpStatusOverrideFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(HttpStatusOverrideFilter.class);
    private static final String X_HTTP_STATUS_OVERRIDE = "X-HTTP-Status-Override";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpStatusOverrideResponseWrapper response = new HttpStatusOverrideResponseWrapper(httpServletResponse);
        filterChain.doFilter(httpServletRequest, response);
        response.overrideHttpStatus();
    }

    private static class HttpStatusOverrideResponseWrapper extends HttpServletResponseWrapper {

        private enum Status {
            OVERRIDE_DISABLED,
            USE_STRING_VALUE,
            USE_INT_VALUE
        }

        private final HttpServletResponse originalHttpServletResponse;
        private String stringValue;
        private int intValue;
        private Status status = Status.OVERRIDE_DISABLED;

        private HttpStatusOverrideResponseWrapper(HttpServletResponse originalHttpServletResponse) {
            super(originalHttpServletResponse);
            this.originalHttpServletResponse = originalHttpServletResponse;
        }

        private void overrideHttpStatus() {
            if (status == Status.OVERRIDE_DISABLED) {
                return;
            }
            try {
                int newStatus = (status == Status.USE_STRING_VALUE) ? Integer.parseInt(stringValue) : intValue;
                if (newStatus < 200 || newStatus > 599 || (newStatus >= 300 && newStatus <= 399)) {
                    logger.error("Status override failed, bad {} value '{}'", X_HTTP_STATUS_OVERRIDE, newStatus);
                    return;
                }
                int oldStatus = originalHttpServletResponse.getStatus();
                originalHttpServletResponse.setStatus(newStatus);
                logger.debug("Status overridden '{}' => '{}'", oldStatus, newStatus);
            } catch (NumberFormatException ex) {
                logger.error("Status override failed, {} value is '{}'", X_HTTP_STATUS_OVERRIDE, stringValue, ex);
            }
        }

        @Override
        public void setHeader(String name, String value) {
            if (X_HTTP_STATUS_OVERRIDE.equalsIgnoreCase(name)) {
                stringValue = value;
                status = Status.USE_STRING_VALUE;
            } else {
                super.setHeader(name, value);
            }
        }

        @Override
        public void addHeader(String name, String value) {
            if (X_HTTP_STATUS_OVERRIDE.equalsIgnoreCase(name)) {
                stringValue = value;
                status = Status.USE_STRING_VALUE;
            } else {
                super.addHeader(name, value);
            }
        }

        @Override
        public void setIntHeader(String name, int value) {
            if (X_HTTP_STATUS_OVERRIDE.equalsIgnoreCase(name)) {
                intValue = value;
                status = Status.USE_INT_VALUE;
            } else {
                super.setIntHeader(name, value);
            }
        }

        @Override
        public void addIntHeader(String name, int value) {
            if (X_HTTP_STATUS_OVERRIDE.equalsIgnoreCase(name)) {
                intValue = value;
                status = Status.USE_INT_VALUE;
            } else {
                super.addIntHeader(name, value);
            }
        }
    }
}
