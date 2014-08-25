package com.test.wildflytransactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@Autowired
	private AccountService service;

	@RequestMapping("/")
	@ResponseBody
	public String test() {
		System.out.println("Count is " + this.service.getCount());
		this.service.createAccountAndNotify("josh");
		try {
			this.service.createAccountAndNotify("error");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		long count = this.service.getCount();
		System.out.println("Count is " + count);
		return "Count is " + count;
	}

}
