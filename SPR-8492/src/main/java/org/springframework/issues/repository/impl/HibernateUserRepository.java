package org.springframework.issues.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.issues.domain.User;
import org.springframework.issues.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HibernateUserRepository implements UserRepository {

	private SessionFactory sessionFactory;

	public HibernateUserRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User user) {
		this.sessionFactory.getCurrentSession().merge(user);
	}

	public User getUser(long id) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class,
				id);
	}

	public void updateUser(User user) {
		this.sessionFactory.getCurrentSession().merge(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return this.sessionFactory.getCurrentSession()
				.getNamedQuery(User.QUERY_ALL_USERS).list();
	}

}
