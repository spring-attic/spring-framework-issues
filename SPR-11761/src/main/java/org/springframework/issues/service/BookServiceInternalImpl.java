package org.springframework.issues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.data.Book;
import org.springframework.issues.data.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceInternalImpl implements BookServiceInternal {

	@Autowired
	private BookRepository books;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createAnotherBook(Book book) {
		books.create(book);
	}

}
