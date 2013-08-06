package org.springframework.issues;

import javax.ejb.Local ;
import javax.ejb.Stateless ;
import javax.ejb.TransactionAttribute ;
import javax.ejb.TransactionAttributeType ;
import javax.persistence.EntityManager ;
import javax.persistence.PersistenceContext ;

@Stateless
@Local(TestEntityDAO.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class TestEntityDAOEJB implements TestEntityDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    private TestEntity getTestEntity(String name) {
		TestEntity te = entityManager.find(TestEntity.class, name);
		if (te == null) {
			te = new TestEntity(name, 0);
			entityManager.persist(te);
		}
		return te;
    }
    
	@Override
	public int getCount(String name) {
		TestEntity te = getTestEntity(name);
		return te.getCount();
	}

	@Override
	// REQUIRES_NEW causes the Spring test to fail; change to REQUIRED and the test will pass.
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public int incrementCount(String name) {
		TestEntity te = getTestEntity(name);
		int count = te.getCount();
		count++;
		te.setCount(count);
		return count;
	}
}
