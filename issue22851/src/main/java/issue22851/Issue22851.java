package issue22851;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Issue22851 {

	@RequestMapping("/")
	@ResponseBody
	public String any() {
		return "anything";
	}

	public static void main(String[] args) {
		run(Issue22851.class, args);
	}
}
