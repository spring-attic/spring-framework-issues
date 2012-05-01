package leak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LeakController {

	@Resource
	private RequestScoped leaker;

	@RequestMapping(value = "/leak", method = RequestMethod.GET)
	public void handler(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");

		response.getWriter().write("The number of dependencies is " + leaker.doSomething());
	}
}
