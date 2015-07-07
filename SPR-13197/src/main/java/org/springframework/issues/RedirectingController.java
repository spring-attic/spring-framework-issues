package org.springframework.issues;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectingController {

	@RequestMapping("/about/benefits")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public Object aboutBenefitsRedirect() {
		return new RedirectView("/about/portfolios");
	}

	@RequestMapping("/about/test")
	@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
	public String testRedirect() {
		return "redirect:/about/portfolios";
	}

}
