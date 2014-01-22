
package org.springframework.issues;

import javax.ejb.EJB ;
import javax.persistence.EntityManager ;
import javax.persistence.PersistenceContext ;

import org.springframework.test.annotation.Rollback ;
import org.springframework.test.context.ContextConfiguration ;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests ;
import org.springframework.transaction.annotation.Transactional ;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.* ;

@ContextConfiguration("context.xml")
@Transactional
public class RollbackIsNotOKDAOTest extends AbstractTransactionalTestNGSpringContextTests {
    
    @EJB
    private TestEntityDAO dao;
    
    @PersistenceContext
    private EntityManager em;
   
    private static final String TESTNAME = "test-name";
    
    @Test()
    @Rollback(true)
    public void testInitialState() {
        int count = dao.getCount(TESTNAME);
        assertEquals("New TestEntity should have count=0", 0, count);
        em.flush();
    }

    
    @Test(dependsOnMethods={"testInitialState"})
    @Rollback(true)
    public void testIncrementCount1() {
        int count = dao.incrementCount(TESTNAME);
        assertEquals("Expected count=1 after first increment", 1, count);
        em.flush();
    }

    
    @Test(dependsOnMethods={"testIncrementCount1"})
    @Rollback(true)
    public void testIncrementCount2() {
        int count = dao.getCount(TESTNAME);
        assertEquals("Expected count=0 after testIncrementCount1 because test should roll back", 0, count);

        count = dao.incrementCount(TESTNAME);
        assertEquals("Expected count=2 now", 2, count);
        em.flush();
    }

}
