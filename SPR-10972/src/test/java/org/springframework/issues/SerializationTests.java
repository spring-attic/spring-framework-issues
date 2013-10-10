package org.springframework.issues;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
    @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml"),
    @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/servlet-context.xml")
})
public class SerializationTests {
    @Autowired WebApplicationContext wac;

    @Test
    public void sessionScopedBeanIsSerializable() throws Exception {
        MockMvc mock = webAppContextSetup(wac).build();

        Object attribute = mock.perform(get("/")).andReturn().getRequest().getSession().getAttribute("scopedTarget.component");

        ObjectOutputStream os = new ObjectOutputStream(new ByteArrayOutputStream());
        os.writeObject(attribute);
    }
}
