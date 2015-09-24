package org.springframework.issues.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("echo")
@Controller
public class EchoController {

	@ModelAttribute
	public EchoForm setUpForm() {
		return new EchoForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST, params = "confirm")
	public String confirm(EchoForm form) {
		return "confirm";
	}

	@RequestMapping(method = RequestMethod.POST, params = "redo")
	public String redo(EchoForm form) {
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String echo(EchoForm form, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("text1", form.getText1());
		redirectAttributes.addFlashAttribute("text2", form.getText2());
		return "redirect:/echo?complete";
	}

	@RequestMapping(method = RequestMethod.GET, params = "complete")
	public String echoComplete() {
		return "complete";
	}

}