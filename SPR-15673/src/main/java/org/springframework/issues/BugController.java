package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Created by jhaeyaert on 16/06/2017.
 */
@Controller
public class BugController {

	@GetMapping(path = "/bug", produces = "text/html; charset=utf-8")
	@ResponseBody
	public Mono<ServerResponse> getTest() {

		return ServerResponse.ok().body(Mono.just("<html><body><p>This should work</p></body></html>"), String.class);
	}
}
