package org.springframework.issues.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GzipController {

	@RequestMapping("/")
	public ResponseEntity<String> helloGzip() {
		return  ResponseEntity.ok()
				.header("Connection", "close")
				.body("Hello World!");
	}
}
