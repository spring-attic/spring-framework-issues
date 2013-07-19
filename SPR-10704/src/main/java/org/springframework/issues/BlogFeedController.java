package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

@Controller
public class BlogFeedController {

	@RequestMapping(value="/blog.atom", method = { GET, HEAD })
	public String listPublishedPosts() {
		return "blogPostAtomViewer";
	}
}
