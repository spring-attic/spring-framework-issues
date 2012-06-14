package org.springframework.security.oauth.examples.tonr.mvc;

import java.net.URI;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

/**
 * @author Dave Syer
 */
@Controller
public class SparklrController {

	private RestOperations restTemplate;

	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/photos")
	public String photos(Model model) throws Exception {
		restTemplate.getForObject(URI.create("http://some/photos"), byte[].class);
		return "sparklr";
	}

}
