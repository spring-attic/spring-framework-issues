package org.springframework.issues;

/**
 * @author Stephane Nicoll
 */
public class SourceTag {

	private String tagId;

	public SourceTag(String tagId) {
		this.tagId = tagId;
	}

	public SourceTag() {
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
}
