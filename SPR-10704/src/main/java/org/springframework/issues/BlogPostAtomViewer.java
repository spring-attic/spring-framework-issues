package org.springframework.issues;

import com.sun.syndication.feed.atom.*;
import org.springframework.web.servlet.view.feed.AbstractAtomFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class BlogPostAtomViewer extends AbstractAtomFeedView {

	@Override
	protected void buildFeedMetadata(Map<String, Object> model, Feed feed, HttpServletRequest request) {
		feed.setTitle("Test Feed");
		feed.setIcon("https://www.example.com/favicon.ico");
		super.buildFeedMetadata(model, feed, request);
	}


	@Override
	protected List<Entry> buildFeedEntries(Map<String, Object> stringObjectMap, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return null;
	}
}