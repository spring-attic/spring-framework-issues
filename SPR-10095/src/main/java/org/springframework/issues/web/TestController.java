/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.issues.web;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces=MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public MultiValueMap<String, Object> getImageAndData() throws Exception {

		Resource logo = new ClassPathResource("logo.jpg", TestController.class);
		BufferedImage image = ImageIO.read(logo.getFile());

		Foo data = new Foo();
		data.setAttribute("bar");

		MultiValueMap<String, Object> mp = new LinkedMultiValueMap<String, Object>();
		mp.add("image", image);
		mp.add("data", data);

		return mp;
	}

}
