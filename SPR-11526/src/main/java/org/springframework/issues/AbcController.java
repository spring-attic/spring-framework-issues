package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class AbcController {


	@RequestMapping(value="")
	@ResponseBody
	public String createCustomer() {
		return "create";
	}

	@RequestMapping(value="delete/{id}")
	@ResponseBody
	public String deleteCustomer() {
		return "delete";
	}

}
