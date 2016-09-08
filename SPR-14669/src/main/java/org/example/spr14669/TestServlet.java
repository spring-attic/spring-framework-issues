package org.example.spr14669;

import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet(urlPatterns = "/test", asyncSupported = true)
public class TestServlet extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(TestServlet.class);


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (!DispatcherType.REQUEST.equals(req.getDispatcherType())) {
			logger.info("Unexpected DispatcherType: " + req.getDispatcherType());
			return;
		}

		AsyncContext asyncContext = req.startAsync(req, resp);
		asyncContext.setTimeout(5000);
		asyncContext.addListener(new AsyncListener() {

			public void onTimeout(AsyncEvent event) throws IOException {
				logger.info("Timeout event");
				ServletResponse response = event.getAsyncContext().getResponse();
				if (!response.isCommitted()) {
					((HttpServletResponse) response).setStatus(503);
				}
				// event.getAsyncContext().complete();
			}

			public void onError(AsyncEvent event) throws IOException { }

			public void onStartAsync(AsyncEvent event) throws IOException { }

			public void onComplete(AsyncEvent event) throws IOException { }
		});

	}

}
