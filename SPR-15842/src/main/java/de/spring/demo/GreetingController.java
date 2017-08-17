package de.spring.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin Burchard
 *
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
class GreetingController {

	@ResponseBody
	@RequestMapping("/greeting1")
	String greeting1() {
		return "OK";
	}

	@RequestMapping("/greeting2")
	ResponseEntity<String> greeting2() {
		return ResponseEntity.ok("OK");
	}

	@RequestMapping("/greeting3")
	ResponseEntity<Map<String, Object>> greeting3() {
		Map<String, Object> map = new HashMap<>();
		map.put("key", "value");
		return ResponseEntity.ok(map);
	}
}
