package org.springframework.issues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.data.Book;
import org.springframework.issues.data.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository books;

	@Autowired
	private BookServiceInternal booksInternal;
	
	@Override
	public void createBook(Book book) {
		books.create(book);
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void createBookWithoutTx(Book book) {
		Book lookup = books.lookup(book.getId());
		if (lookup != null) {
			throw new IllegalArgumentException("Entity already exists " + book);
		}
		booksInternal.createAnotherBook(book);
	}
	
	@Override
	public Book lookupBookById(long id) {
		return books.lookup(id);
	}
	
	@Override
	public void triggerCreatePostCommit(final Book book) {
		
		// Lookup book to make sure we are using the enitity manager/repository
		lookupBookById(book.getId());
		
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCompletion(int status) {
				if (status == TransactionSynchronization.STATUS_COMMITTED) {
					BookServiceHelper.getInstance().getBookService().createBookWithoutTx(book);
				}
			}
		});
	}

	
}
