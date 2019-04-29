package issue22853;

import static java.net.http.HttpClient.Version.HTTP_1_1;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.TEXT_HTML;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import issue22853.SpringIT.AnyController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AnyController.class)
@AutoConfigureMockMvc
public class SpringIT {

	@Controller
	@SpringBootApplication
	static class AnyController {

		@RequestMapping("/failing")
		public void fail() throws Exception {
			throw new Exception();
		}

		@Configuration
		static class DefaultContentTypeConfiguration implements WebMvcConfigurer {

			@Override
			public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
				configurer.defaultContentType(TEXT_HTML);
			}
		}
	}

	@Test
	public void NonExistingUrlShouldReturn404() {
		var status = get("/nonExisting");
		assertEquals(404, status);
	}

	@Test
	public void errorShouldReturn500() {
		var status = get("/failing");
		assertEquals(500, status);
	}

	@LocalServerPort
	private int port;

	private int get(String path) {
		try {
			var httpClient = HttpClient.newBuilder().version(HTTP_1_1).build();
			var request = HttpRequest.newBuilder().uri(new URI("http://localhost:" + port + path)).GET().build();
			var response = httpClient.send(request, BodyHandlers.discarding());
			return response.statusCode();

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
