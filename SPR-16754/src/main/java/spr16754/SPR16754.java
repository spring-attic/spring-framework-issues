package spr16754;

import static org.springframework.http.ResponseEntity.ok;

import java.io.InputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SPR16754 {

	public static void main(String[] args) {
		SpringApplication.run(SPR16754.class, args);
	}

	@GetMapping("/")
	public ResponseEntity<InputStreamResource> download() {
		InputStream stream = getClass().getResourceAsStream("/blob");
		BodyBuilder builder = ok();
		builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
		return builder.body(new InputStreamResource(stream));
	}

}
