package com.flozano.issuewithemptybodies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/something")
public class SomethingController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		return new ResponseEntity<String>("Hello there", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> post(@RequestBody String input) {
		return new ResponseEntity<String>("Input was: " + input,
				HttpStatus.CREATED);
	}
}
