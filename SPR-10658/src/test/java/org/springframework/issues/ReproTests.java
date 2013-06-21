package org.springframework.issues;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);

        Book book = bookService.getBook(1);

        assertThat(book, nullValue()); //book not found, null cached

        //add book with id = 1
        int bookId = bookService.addBook(new Book()); // key="#result" resolved to null instead of 1

        assertThat(bookId, is(1));

        //get book with id = 1 again
        book = bookService.getBook(1);

        //must be not null!
        assertThat(book, notNullValue());

        assertThat(book.getId(), is(1));
	}

}
