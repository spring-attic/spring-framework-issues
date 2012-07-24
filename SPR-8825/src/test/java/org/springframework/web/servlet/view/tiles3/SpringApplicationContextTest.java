package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import org.apache.tiles.request.ApplicationResource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.mock.web.MockServletContext;

public class SpringApplicationContextTest {

    private SpringApplicationContext testTarget;
    private ServletContext servletContext = new MockServletContext();
    private ApplicationContext applicationContext;

    @Before
    public void setUp() {
        testTarget = new SpringApplicationContext();
        applicationContext = createMock(ApplicationContext.class);
        testTarget.setApplicationContext(applicationContext);
        testTarget.setServletContext(servletContext);
   }

    @Test
    public void testInitParams() {
        expect(applicationContext.getBeanDefinitionNames()).andReturn(new String[] {}).anyTimes();
        Map<String, String> initParams = new HashMap<String, String>();
        servletContext.setInitParameter("param1", "value1");
        servletContext.setInitParameter("param2", "value2");
        replay(applicationContext);
        for (Entry<String, String> entry : initParams.entrySet()) {
            assertEquals(entry.getKey() + " has a different value", entry.getValue(),
                    testTarget.getInitParams().get(entry.getKey()));
        }
        verify(applicationContext);
    }

    @Test
    public void testApplicationScope() {
        Object bean1 = new Object();
        servletContext.setAttribute("bean1", bean1);
        Object bean2 = new Object();
        servletContext.setAttribute("bean2", bean2);
        replay(applicationContext);
        assertEquals("bean1 is not found", bean1, testTarget.getApplicationScope().get("bean1"));
        assertEquals("bean2 is not found", bean2, testTarget.getApplicationScope().get("bean2"));
        verify(applicationContext);
    }

    @Test
    public void testGetResource() throws IOException {
        UrlResource resource1 = new UrlResource("file:/test/resource1.xml");
        UrlResource resource2 = new UrlResource("file:/test/resource2.xml");
        UrlResource resource1English = new UrlResource("file:/test/resource1_en.xml");
        UrlResource resource1Italy = new UrlResource("file:/test/resource1_it_IT.xml");
        expect(applicationContext.getResource("resource1.xml")).andReturn(resource1).anyTimes();
        expect(applicationContext.getResource("resource2.xml")).andReturn(resource2).anyTimes();
        expect(applicationContext.getResource("resource1_en.xml")).andReturn(resource1English).anyTimes();
        expect(applicationContext.getResource("resource1_it_IT.xml")).andReturn(resource1Italy).anyTimes();
        expect(applicationContext.getResource("file:/test/resource1.xml")).andReturn(resource1).anyTimes();
        expect(applicationContext.getResource("file:/test/resource2.xml")).andReturn(resource2).anyTimes();
        expect(applicationContext.getResource("file:/test/resource1_en.xml")).andReturn(resource1English).anyTimes();
        expect(applicationContext.getResource("file:/test/resource1_it_IT.xml")).andReturn(resource1Italy).anyTimes();
        replay(applicationContext);
        assertEquals(resource1.getURL().toExternalForm(), testTarget.getResource("resource1.xml").getLocalePath());
        assertEquals(resource2.getURL().toExternalForm(), testTarget.getResource("resource2.xml").getLocalePath());
        assertEquals(resource1English.getURL().toExternalForm(), testTarget.getResource("resource1_en.xml")
                .getLocalePath());
        assertEquals(resource1Italy.getURL().toExternalForm(), testTarget.getResource("resource1_it_IT.xml").getLocalePath());
        ApplicationResource applicationResource1 = testTarget.getResource("resource1.xml");
        assertEquals(resource1English.getURL().toExternalForm(),
                testTarget.getResource(applicationResource1, Locale.ENGLISH).getLocalePath());
        assertEquals(resource1Italy.getURL().toExternalForm(),
                testTarget.getResource(applicationResource1, Locale.ITALY).getLocalePath());
        verify(applicationContext);
    }

    @Test
    public void testGetResources() throws IOException {
        UrlResource resource1 = new UrlResource("file:/test/resource1.xml");
        UrlResource resource2 = new UrlResource("file:/test/resource2.xml");
        UrlResource resource1English = new UrlResource("file:/test/resource1_en.xml");
        UrlResource resource1Italy = new UrlResource("file:/test/resource1_it_IT.xml");
        expect(applicationContext.getResources("resource*")).andReturn(
                new Resource[] { resource1, resource1English, resource1Italy, resource2 });
        replay(applicationContext);
        Collection<ApplicationResource> resources = testTarget.getResources("resource*");
        assertEquals("wrong list of resources", 4, resources.size());
        for (ApplicationResource resource : resources) {
            String path = resource.getPath();
            Locale locale = resource.getLocale();
            assertTrue(path.equals("file:/test/resource1.xml") || path.equals("file:/test/resource2.xml"));
            assertTrue(Locale.ROOT.equals(locale) || Locale.ENGLISH.equals(locale) || Locale.ITALY.equals(locale));
        }
        verify(applicationContext);
    }
}
