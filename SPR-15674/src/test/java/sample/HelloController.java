package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Rob Winch
 * @since 5.0
 */
@RestController
public class HelloController {

	@GetMapping("/")
	public Mono<String> hello() {
		return Mono.just("Hello");
	}
}
