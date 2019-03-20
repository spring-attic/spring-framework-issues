
package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Model login() {
		return new ExtendedModelMap().addAttribute(new ActivateAccountForm());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processActivationForm(@Validated ActivateAccountForm form, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		return "redirect:https://www.springsource.org";
	}

}
