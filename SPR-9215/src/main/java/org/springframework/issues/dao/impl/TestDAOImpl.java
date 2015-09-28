package org.springframework.issues.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.issues.dao.TestDAO;
import org.springframework.issues.datamodel.TestData;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public TestData saveTestData(TestData entity) {
		TestData ret = em.merge(entity);
		return ret;
	}

	@Override
	public TestData loadTestDataById(Long id) {
		return em.find(TestData.class, id);
	}
}
