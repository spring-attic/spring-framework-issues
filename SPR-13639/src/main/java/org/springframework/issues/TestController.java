package org.springframework.issues;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Brian Clozel
 */

@RestController
public class TestController {

	@RequestMapping(path="/put", method= RequestMethod.PUT)
	public ResponseEntity putTest() {
		return ResponseEntity.ok().build();
	}

	@RequestMapping(path="/post", method= RequestMethod.POST)
	public ResponseEntity<String> postTest() {
		return ResponseEntity.ok("test");
	}
}
