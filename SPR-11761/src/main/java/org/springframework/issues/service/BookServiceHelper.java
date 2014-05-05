package org.springframework.issues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceHelper {

	@Autowired
	private BookService bookService;
	
	private static BookServiceHelper instance;
	
	public BookServiceHelper() {
		instance = this;
	}
	
	public static BookServiceHelper getInstance() {
		return instance;
	}
	
	public BookService getBookService() {
		return bookService;
	}
}
