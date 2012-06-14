package org.springframework.security.oauth.examples.tonr.mvc;

import org.springframework.security.oauth2.client.context.OAuth2ClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dave Syer
 */
@Controller
public class HomeController {

	private OAuth2ClientContext context;

	public void setClientContext(OAuth2ClientContext context) {
		this.context = context;
	}

	@RequestMapping("/home")
	public String home(Model model) throws Exception {
		model.addAttribute("parameters", context.getAccessTokenRequest());
		return "home";
	}

}
