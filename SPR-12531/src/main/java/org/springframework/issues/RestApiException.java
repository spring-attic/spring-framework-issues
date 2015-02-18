package org.springframework.issues;

import java.util.UUID;

import org.springframework.http.HttpStatus;

public class RestApiException extends RuntimeException {

	private final RestApiError error;


	public RestApiException(RestApiError error) {
		this.error = error;
	}

	public RestApiException(HttpStatus httpStatus, UUID errorCode, String userMessage, String developerMessage) {
		this.error = new RestApiError(httpStatus, errorCode, userMessage, developerMessage);
	}

	public RestApiError getError() {
		return this.error;
	}

}
