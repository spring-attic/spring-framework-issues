package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.config.AppConfig;
import org.springframework.issues.data.Book;
import org.springframework.issues.service.BookService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ReproTests {

	@Autowired
	private BookService books;
	
	@Test
	public void test() throws InterruptedException {
		final Book book1 = new Book(1, "A");
		books.createBook(book1);
		final Book book2 = new Book(2, "B");
		books.createBook(book2);

		final Book book3 = new Book(3, "C");
		books.createBookWithoutTx(book3);
		
		final Book bookAfterCommit = new Book(55, "AFTER COMMIT");
		books.triggerCreatePostCommit(bookAfterCommit);
		final Book book4 = new Book(4, "D");
		books.createBook(book4);
		
		assertEquals(book1, books.lookupBookById(1));
		assertEquals(book2, books.lookupBookById(2));
		
		// Book triggered post commit is found
		assertEquals(bookAfterCommit, books.lookupBookById(55));
		// Books after the post commit are not found within the same thread.
		assertEquals(book4, books.lookupBookById(4));
		// Even the older ones
		assertEquals(book3, books.lookupBookById(3));
		
		final Reference<Boolean> foundBook4 = new Reference<Boolean>(false);
		final Reference<Boolean> foundBookAfterCommit = new Reference<Boolean>(false);
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				// Books are not found however while executing in a separate thread (not even in DB)
				foundBook4.set(books.lookupBookById(4) != null);
				foundBookAfterCommit.set(books.lookupBookById(55) != null);
			}
		};
		
		thread.start();
		thread.join();
		
		assertTrue(foundBookAfterCommit.get());
		assertTrue(foundBook4.get()); // Should fail since book was not found in separate thread
		
	}
}
