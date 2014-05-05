package org.springframework.issues.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void create(Book book) {
		em.persist(book);
	}
	
	public Book lookup(long id) {
		return em.find(Book.class, id);
	}
}
