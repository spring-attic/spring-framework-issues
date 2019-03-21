package issue22626;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.http.ResponseEntity.ok;

import java.io.InputStream;
import java.util.function.Supplier;

import org.apache.commons.io.input.NullInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Issue22626 {

	@Autowired(required = false)
	private Supplier<InputStream> source = () -> new NullInputStream(10000);

	@GetMapping("/")
	public ResponseEntity<InputStreamResource> download() {
		var resource = new InputStreamResource(source.get());
		return ok().eTag("Issue22626").lastModified(22626).body(resource);
	}

	public static void main(String[] args) {
		run(Issue22626.class, args);
	}
}
