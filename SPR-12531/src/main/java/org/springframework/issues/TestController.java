package org.springframework.issues;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


	@RequestMapping("/requiredParam")
	public void handleRequiredParam(@RequestParam String foo) {
	}

}
