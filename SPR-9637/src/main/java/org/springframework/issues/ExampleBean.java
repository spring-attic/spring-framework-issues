package org.springframework.issues;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean {

	@Value("#{exampleSource.date}")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date injectedField;
	
	private Date injectedMethod;
	
	public Date getInjectedDate() {
		return injectedField;
	}
	
	
	public Date getInjectedMethod() {
		return injectedMethod;
	}
	
	@Value("#{exampleSource.date}")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public void setInjectedMethod(Date injectedMethod) {
		this.injectedMethod = injectedMethod;
	}
}
