package org.springframework.issues;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *
 * @author chemist
 * @since 0.0.1
 */
public class BookServiceImpl implements BookService {
    private Map<Integer, Book> books = new HashMap<>();
    private int cnt = 0;

    @CacheEvict(value = "testCache", key = "#result")
    @Override
    public int addBook(Book book) {
        cnt++;
        book.setId(cnt);
        books.put(cnt, book);
        System.out.println("addBook return: " + cnt);
        return cnt;
    }

    @Cacheable(value = "testCache", key = "#p0")
    @Override
    public Book getBook(int bookId) {
        return books.get(bookId);
    }
}
