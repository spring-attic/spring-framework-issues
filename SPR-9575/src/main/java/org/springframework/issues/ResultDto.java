package org.springframework.issues;



public class ResultDto {

	private String content;
	private ResultCode processCode;

	public ResultCode getProcessCode() {
		return processCode;
	}

	public void setProcessCode(ResultCode processCode) {
		this.processCode = processCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
