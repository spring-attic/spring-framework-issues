import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Sample {
	
	@RequestMapping("/")
	String home() {
		"Hello World"
	}
	
}