package demo;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test", asyncSupported = true)
public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DispatcherType=" + req.getDispatcherType());
		System.out.println("AsyncStarted=" + req.isAsyncStarted());

		if (req.getDispatcherType().equals(DispatcherType.REQUEST)) {
			System.out.println("Starting async request");
			req.startAsync(req, resp);
		}
	}

}
