package demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(classes = DemoWebApplicationContextSetupTests.RootConfig.class),
		@ContextConfiguration(classes = DemoWebApplicationContextSetupTests.ServletConfig.class)
})
@WebAppConfiguration
public class DemoWebApplicationContextSetupTests {

	@Configuration
	static class RootConfig {
		@Bean
		public String fooBean() {
			return "foo";
		}
	}

	@Configuration
	static class ServletConfig { }

    @Autowired WebApplicationContext applicationContext;
    @Autowired ServletContext servletContext;
    MockMvc mockMvc;

    @Before
    public void setUp() {
        // comment this out to see that the test will succeed then with Spring versions > 4.1.3
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

	@Test
	public void rootContext() {
        WebApplicationContext rootContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        assertNull("Root context should not have parent context", rootContext.getParent());
        assertNotNull("Root context should contain bean of type String", rootContext.getBeansOfType(String.class));
    }

}
