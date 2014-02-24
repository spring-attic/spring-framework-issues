package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Stephane Nicoll
 */
@Controller()
public class SimpleController {

	private final SourceService sourceService = new SourceService();

	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.PUT)
	public @ResponseBody SourceTag updateTag(@RequestBody SourceTag newTag, @PathVariable("tagId") String tagId) {
		return sourceService.updateTag(new SourceTag(tagId), newTag);
	}

	@RequestMapping(value = "/tag/{tagId}", method = RequestMethod.DELETE)
	public @ResponseBody SourceTag updateTag(@PathVariable("tagId") String tagId) {
		return new SourceTag(tagId);
	}

}
