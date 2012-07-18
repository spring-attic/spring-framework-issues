package org.springframework.issues;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestHandler;

@Transactional
public class ConsoleHandler implements HttpRequestHandler, ApplicationContextAware, MyHttpRequestHandler {

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	}

    public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().write("Success");
	}


}
