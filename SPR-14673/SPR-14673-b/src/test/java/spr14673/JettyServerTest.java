package spr14673;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JettyServerTest {

	private static JettyServer jettyServer;

	@BeforeClass
	public static void setup() throws Exception {
		jettyServer = new JettyServer();
		jettyServer.start();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		jettyServer.stop();
	}

	@Test
	public void testThroughDispatcherServlet() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8080/admin");
		CloseableHttpResponse response = httpclient.execute(httpget);

		String cs = getCharset(response.getEntity().getContentType());

		if (cs == null) {
			cs = StandardCharsets.UTF_8.name();
		}

		InputStream content = response.getEntity().getContent();
		String[] datas = new String[2];
		int index = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(content, cs))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String wrongWayString = "Wrong way: ";
				int offset = line.indexOf(wrongWayString);
				if (offset == -1) {
					continue;
				}
				offset += wrongWayString.length();
				int brOffset = line.indexOf("<br>");
				String data = line.substring(offset, brOffset);
				datas[index++] = data;
			}
		}

		assertNotNull(datas[0]);
		assertNotNull(datas[1]);

		assertEquals("Administração", datas[0]);
		assertEquals("Coleções", datas[1]);
	}

	@Test
	public void testDirect() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://localhost:8080/admin.html");
		CloseableHttpResponse response = httpclient.execute(httpget);

		String cs = getCharset(response.getEntity().getContentType());

		if (cs == null) {
			// default to UTF-8 because the original file is in UTF-8
			cs = StandardCharsets.UTF_8.name();
		}

		InputStream content = response.getEntity().getContent();
		String[] datas = new String[2];
		int index = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(content, cs))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String wrongWayString = "Wrong way: ";
				int offset = line.indexOf(wrongWayString);
				if (offset == -1) {
					continue;
				}
				offset += wrongWayString.length();
				int brOffset = line.indexOf("<br>");
				String data = line.substring(offset, brOffset);
				datas[index++] = data;
			}
		}

		assertNotNull(datas[0]);
		assertNotNull(datas[1]);

		assertEquals("Administração", datas[0]);
		assertEquals("Coleções", datas[1]);
	}

	private String getCharset(Header contentType) {
		HeaderElement[] elements = contentType.getElements();
		for (int i = 0; i < elements.length; i++) {
			HeaderElement headerElement = elements[i];
			NameValuePair[] parameters = headerElement.getParameters();
			for (int j = 0; j < parameters.length; j++) {
				NameValuePair nameValuePair = parameters[j];
				if ("charset".equals(nameValuePair.getName())) {
					return nameValuePair.getValue();
				}
			}
		}
		return null;
	}

}
