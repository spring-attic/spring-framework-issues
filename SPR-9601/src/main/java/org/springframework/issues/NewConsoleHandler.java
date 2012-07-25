package org.springframework.issues;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.HttpRequestHandler;

/**
 * This class implements a custom annotated interface instead of {@link HttpRequestHandler}.
 */
public class NewConsoleHandler implements ConsoleHandler, ApplicationContextAware {

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	}

    @Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().write("Success");
	}


}
