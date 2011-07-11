package com.vodori.jpa.dao;

import com.vodori.jpa.model.AbstractParent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 *
 *
 *
 */
@Component
public class SampleDAOImpl implements SampleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //~--- methods ------------------------------------------------------------

    @Override
    public void saveObject(AbstractParent theObject) {
        entityManager.persist(theObject);
    }
}
