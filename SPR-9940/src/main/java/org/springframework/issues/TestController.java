package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(method = RequestMethod.POST, value = "/url", consumes="application/x-www-form-urlencoded")
	@ResponseBody
	public String method(@RequestBody(required=false) MultiValueMap<String, String> values) {
		return "Got [" + values + "]";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/url", consumes="application/json")
	@ResponseBody
	public String method(@RequestBody(required=false) MyBody myBody) {
		return "Got [" + myBody + "]";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/mav")
	public String handle(Model model) {
		MyBody myBody = new MyBody();
		myBody.setName("Jon");
		model.addAttribute(myBody);
		return "view";
	}

}
