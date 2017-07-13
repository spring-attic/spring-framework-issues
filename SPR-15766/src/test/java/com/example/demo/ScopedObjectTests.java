package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ScopedObjectTests {
	
	@Autowired
	private MockMvc mockMvc; 

	@Test
	public void test() throws Exception {
		MvcResult response = mockMvc.perform(get("/")).andReturn();
		assertThat(response.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
		Map<?,?> map = (Map<?, ?>) ReflectionTestUtils.getField(DefaultListableBeanFactory.class, "serializableFactories");
		// This simulates running in another JVM where the serialization ids don't match
		map.clear();
		MvcResult other = mockMvc.perform(get("/")).andReturn();
		assertThat(other.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}

}
