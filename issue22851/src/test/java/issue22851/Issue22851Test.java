package issue22851;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Issue22851Test {

	@LocalServerPort
	private int port;

	@Test
	public void shouldReturn404() throws Exception {
		var url = new URL("http://localhost:" + port + "/%ED%B6");
		var connection = (HttpURLConnection) url.openConnection();
		assertEquals(404, connection.getResponseCode());
	}
}
