package org.springframework.issues;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;


@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping(value = { "**/something" })
	public void showPathWithinHandler(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pathWithinHandler = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		IOUtils.write("pathWithinHandler = " + pathWithinHandler, response.getOutputStream());
	}

}
