package spring.framework.issues._13944;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Spr13944Application {

    private static Logger log = LoggerFactory.getLogger(Spr13944Application.class);
    
	public static void main(String[] args) {
		SpringApplication.run(Spr13944Application.class, args);

        RestTemplate restTemplate = new RestTemplate();
        String badUrl = "http://localhost:8080/greetings";
        for (HttpMethod httpMethod : HttpMethod.values()) {
            try {
                restTemplate.execute(badUrl, httpMethod, null, null);
            } catch (Exception e) {
                log.error("Failed to " + httpMethod + " -- " + e.getMessage());
            }
        }
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return "hello";
    }
}
