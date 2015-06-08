package demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;

import org.junit.Before;
import org.junit.Test;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class DemoStandaloneSetupTests {

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new MyController()).build();
    }

	@Test
	public void rootContext() throws Exception {
		mockMvc.perform(get("/test")).andExpect(content().string("true"));
    }


	@Controller
	public static class MyController {

		@RequestMapping("/test")
		@ResponseBody
		public boolean handle(ServletRequest request) {
			return WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()) != null;
		}

	}

}
