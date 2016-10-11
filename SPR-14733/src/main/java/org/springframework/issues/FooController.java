package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class FooController {

	@PutMapping("/foo")
	public ResponseEntity<Void> handlePut(HttpServletRequest request) {
		System.out.println("\nhandlePut: " + request.getCharacterEncoding() + "\n");
		return ResponseEntity.noContent().build();
	}

}
