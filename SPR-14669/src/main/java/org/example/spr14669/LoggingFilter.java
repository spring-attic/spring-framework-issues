package org.example.spr14669;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.servlet.DispatcherType.ASYNC;
import static javax.servlet.DispatcherType.ERROR;
import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.INCLUDE;
import static javax.servlet.DispatcherType.REQUEST;

@WebFilter(
		urlPatterns = "/*",
		asyncSupported = true,
		dispatcherTypes = {REQUEST, ERROR, ASYNC, FORWARD, INCLUDE}
)
public class LoggingFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(LoggingFilter.class);


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) req;
		logger.info("\n\n" + httpReq.getMethod() + " " + httpReq.getRequestURI() +
				", DispatcherType: " + req.getDispatcherType() + "\n\n");

		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException { }

	public void destroy() { }

}
