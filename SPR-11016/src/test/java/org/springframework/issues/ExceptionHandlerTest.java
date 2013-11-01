package org.springframework.issues;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.exceptions.CheckedException;
import org.springframework.issues.exceptions.UncheckedException;
import org.springframework.issues.web.CatchAllExceptionHandler;
import org.springframework.issues.web.CheckedExceptionHandler;
import org.springframework.issues.web.ExampleController;
import org.springframework.issues.web.UncheckedExceptionHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
@WebAppConfiguration
public class ExceptionHandlerTest {
	@Autowired
	FooService mockService;
	@Autowired
	WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		Mockito.reset(mockService);
	}
	
	@Test
	public void exceptionHandledByCatchAll() throws Throwable {
		Mockito.when(mockService.get()).thenThrow(new Exception());
		mvc.perform(get(ExampleController.PATH)).andExpect(content().string(CatchAllExceptionHandler.RESPONSE));
	}
	
	@Test
	public void uncheckedExceptionHandled() throws Throwable {
		Mockito.when(mockService.get()).thenThrow(new UncheckedException());
		mvc.perform(get(ExampleController.PATH)).andExpect(content().string(UncheckedExceptionHandler.RESPONSE));
	}

	@Test
	public void checkedExceptionHandled() throws Throwable {
		Mockito.when(mockService.get()).thenThrow(new CheckedException());
		mvc.perform(get(ExampleController.PATH)).andExpect(content().string(CheckedExceptionHandler.RESPONSE));
	}
}
