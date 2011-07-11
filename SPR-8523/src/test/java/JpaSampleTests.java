import com.vodori.jpa.dao.SampleDAO;
import com.vodori.jpa.model.ConcreteChild;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 *
 *
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext-jpa.xml")
public class JpaSampleTests {

    @Autowired
    private SampleDAO sampleDAO;


    @Test
    @Transactional
    public void testAbstractParent() {

        ConcreteChild objectToStore = new ConcreteChild();
        objectToStore.setDataPoint1("Parent Data");
        objectToStore.setChildData1("Child Data 1");
        objectToStore.setChildData2("Child Data 2");


        //  If the line below is commented out, the two @Entity classes are enhanced.  If it is allowed to run
        //  then they are not enhanced and an org.apache.openjpa.persistence.ArgumentException is thrown because
        //  runtime optimization is not allowed

         sampleDAO.saveObject(objectToStore);

        assertNotNull(objectToStore.getId());

    }
}
