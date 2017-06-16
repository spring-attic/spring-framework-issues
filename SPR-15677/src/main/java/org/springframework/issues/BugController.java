package org.springframework.issues;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * Created by jhaeyaert on 16/06/2017.
 */
@Controller
public class BugController {

	@PostMapping(path = "/bug", produces = "text/html; charset=utf-8")
	@ResponseBody
	public Mono<ResponseEntity<String>> getTest(@RequestBody Mono<String> data) {

		return data.map(s -> "<html><body><p>" + s + "</p></body></html>").flatMap(s -> Mono.just(ResponseEntity.ok(s)));
	}
}
