package org.springframework.issues.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

	@RequestMapping("/foo")
	@ResponseBody
	public String search(SearchCriteria criteria, @RequestParam String age) {
		return "Searched " + criteria;
	}

}
