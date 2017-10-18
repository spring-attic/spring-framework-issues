package org.springframework.issues;

import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

/**
 * @author Greg Potter
 * @since 10/17/17
 */
@Transactional
@Rollback
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    private JdbcTemplate template;


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testOnlyTemplate() {
        List<Integer> nums = template.query("SELECT * FROM test", new IntegerRowMapper());
        assertEquals(3, nums.size());
        assertEquals(1, (int)nums.get(0));
        assertEquals(2, (int)nums.get(1));
        assertEquals(5, (int)nums.get(2));
    }

    @Test(expected = ConstraintViolationException.class)
    public void testWithHibernate() {
        TestEntity anotherEntity = new TestEntity(10);
        sessionFactory.getCurrentSession().save(anotherEntity);
        template.execute("INSERT INTO test (id) VALUES (10)");
//        assertNotNull(TransactionSynchronizationManager.getResource(dataSource));
        sessionFactory.getCurrentSession().flush(); // Flush is after the template--if it was the same connection it shouldn't matter
    }
}
