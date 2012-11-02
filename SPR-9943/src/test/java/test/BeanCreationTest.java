package test;

import com.amazonaws.ClientConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config.xml")
public class BeanCreationTest {

    @Autowired
    ClientConfiguration clientConfiguration;

    @Test
    public void canCreateClientConfiguration() {
        assertNotNull(clientConfiguration);
    }
}
