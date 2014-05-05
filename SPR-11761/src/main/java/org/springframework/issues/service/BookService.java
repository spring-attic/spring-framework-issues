package org.springframework.issues.service;

import org.springframework.issues.data.Book;

public interface BookService {

	void createBook(Book book);
	
	void createBookWithoutTx(Book book);
	
	Book lookupBookById(long id);
	
	void triggerCreatePostCommit(Book book);
	
}
