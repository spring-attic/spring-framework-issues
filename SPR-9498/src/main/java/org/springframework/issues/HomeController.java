/*
 * Cloud Foundry 2012.02.03 Beta
 * Copyright (c) [2009-2012] VMware, Inc. All Rights Reserved.
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product includes a number of subcomponents with
 * separate copyright notices and license terms. Your use of these
 * subcomponents is subject to the terms and conditions of the
 * subcomponent's license, as noted in the LICENSE file.
 */

package org.springframework.issues;

import java.util.Map;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dave Syer
 * 
 */
@Controller
public class HomeController {
	
	private OAuth2RestTemplate bar;
	
	public void setBar(OAuth2RestTemplate bar) {
		this.bar = bar;
	}

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("parameters", bar.getOAuth2ClientContext().getAccessTokenRequest());
		return "home";
	}

}
