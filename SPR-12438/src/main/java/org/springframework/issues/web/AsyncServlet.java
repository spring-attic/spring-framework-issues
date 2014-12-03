package org.springframework.issues.web;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class AsyncServlet extends HttpServlet {

	private ApplicationContext applicationContext;

	public AsyncServlet(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AsyncContext async = request.startAsync();

		String info=request.getPathInfo();


		Resource resource = applicationContext.getResource("classpath:/spring-logo.png");
		response.setContentLengthLong(resource.contentLength());
		response.setHeader("Content-Type","image/png");

		InputStream is = Files.newInputStream(resource.getFile().toPath());

		ServletOutputStream out = response.getOutputStream();
		out.setWriteListener(new StandardDataStream(is, async, out));
		/*
		else {

			byte[] bytes = "Hello World!".getBytes(Charset.forName("UTF-8"));
			ServletOutputStream out = response.getOutputStream();
			for(int i=0; i<4096; i++) {
				out.write(bytes);
			}
			async.complete();
		}
		*/

	}
}
