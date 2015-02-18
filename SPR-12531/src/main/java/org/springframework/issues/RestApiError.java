package org.springframework.issues;

import java.util.UUID;

import org.springframework.http.HttpStatus;


public class RestApiError {

	private HttpStatus httpStatus;

	private UUID errorCode;

	private String userMessage;

	private String developerMessage;


	public RestApiError(HttpStatus httpStatus, UUID errorCode, String userMessage, String developerMessage) {
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.userMessage = userMessage;
		this.developerMessage = developerMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public UUID getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(UUID errorCode) {
		this.errorCode = errorCode;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
