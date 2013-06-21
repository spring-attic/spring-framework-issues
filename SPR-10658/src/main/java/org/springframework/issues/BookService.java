package org.springframework.issues;

/**
 * Description
 *
 * @author chemist
 * @since 0.0.1
 */
public interface BookService {
    int addBook(Book book);
    Book getBook(int bookId);
}
