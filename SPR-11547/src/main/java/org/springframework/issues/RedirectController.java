package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/circuit/{id}/extend")
	public String handle() {
		return "redirect:/circuit/{id}/view";
	}


}
