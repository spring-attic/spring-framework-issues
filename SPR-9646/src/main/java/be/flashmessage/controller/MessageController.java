package be.flashmessage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	boolean beenThere = false;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet(ModelAndView mav) {
		mav.setViewName("display-message");
		return mav;
	}

	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ModelAndView createNewMessage(ModelAndView mav, RedirectAttributes flash) {
		flash.addFlashAttribute("flash_msg", "number");
		mav.setViewName("redirect:/messages");
		return mav;
	}

	@RequestMapping(value="/new2", method = RequestMethod.POST)
	public ModelAndView createNewMessage2(ModelAndView mav, RedirectAttributes flash) {
		flash.addFlashAttribute("flash_msg", "letter");
		if(!beenThere){
			mav.setViewName("redirect:/messages");
		} else {
			mav.setViewName("display-message");
		}
		beenThere = !beenThere;
		return mav;
	}
}
