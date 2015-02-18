package org.springframework.issues;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;


@ControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Map<Class<? extends Exception>, UUID> errorCodes =
			new HashMap<Class<? extends Exception>, UUID>();

	static {
		errorCodes.put(NoSuchRequestHandlingMethodException.class, UUID.fromString("3ce3e8bc-7499-4fdf-92a1-7a52c570ada3"));
		errorCodes.put(HttpRequestMethodNotSupportedException.class, UUID.fromString("ef7c0cb6-7e3c-4688-829e-c7f3f935c47a"));
		errorCodes.put(HttpMediaTypeNotSupportedException.class,  UUID.fromString("9d34eccf-cf7f-42d4-b489-0d07072e6adf"));
		errorCodes.put(HttpMediaTypeNotAcceptableException.class,  UUID.fromString("eebbfe50-8c0b-4184-ba27-f90ce0a0fe71"));
		errorCodes.put(MissingServletRequestParameterException.class, UUID.fromString("6ec6764d-11e7-4764-9912-82f066a7dfb0"));
		errorCodes.put(ServletRequestBindingException.class, UUID.fromString("1202b975-9626-4ba1-a4d9-15953623bee6"));
		errorCodes.put(ConversionNotSupportedException.class, UUID.fromString("52961957-7cae-46eb-916a-008024774582"));
		errorCodes.put(TypeMismatchException.class, UUID.fromString("532facae-e942-4192-b54a-a065d3d685a4"));
		errorCodes.put(HttpMessageNotReadableException.class, UUID.fromString("297bdf06-30b5-442b-98c0-2087976d0700"));
		errorCodes.put(HttpMessageNotWritableException.class, UUID.fromString("f3816633-32f8-4f0b-a568-f76656c268fd"));
		errorCodes.put(MethodArgumentNotValidException.class, UUID.fromString("871e5e5c-e3cd-4ad6-bab3-c130111e850c"));
		errorCodes.put(MissingServletRequestPartException.class, UUID.fromString("ffb04f64-90dd-45e7-b753-c522b35b6b85"));
		errorCodes.put(BindException.class, UUID.fromString("7f9584d5-cfc5-42eb-b375-901d239fa604"));
		errorCodes.put(NoHandlerFoundException.class, UUID.fromString("c1fe1338-fdfc-448a-b1e2-d6a3cfbd8f75"));
	}


	// Spring MVC Exceptions

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String userMessage = "An Error has occured and the request could not be completed";
		String developerMessage = "Error details: " + ex.getClass().getSimpleName();
		RestApiError error = new RestApiError(status, errorCodes.get(ex.getClass()), userMessage, developerMessage);

		return super.handleExceptionInternal(ex, error, headers, status, request);
	}


	// Add more @ExceptionHandler methods for application-specific exceptions here

}
