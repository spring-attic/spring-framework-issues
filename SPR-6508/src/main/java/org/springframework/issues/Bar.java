package org.springframework.issues;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Bar {

	private Date date;

	@DateTimeFormat(iso=ISO.DATE_TIME)
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
}
