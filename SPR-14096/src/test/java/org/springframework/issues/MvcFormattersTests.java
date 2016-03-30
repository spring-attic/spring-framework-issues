package org.springframework.issues;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy(@ContextConfiguration(classes = WebConfig.class))
public class MvcFormattersTests {


	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testConversionService() throws Exception {

		FormattingConversionService conversionService =
				this.wac.getBean("mvcConversionService", FormattingConversionService.class);

		Field converterField = ReflectionUtils.findField(FormattingConversionService.class, "converters");
		ReflectionUtils.makeAccessible(converterField);
		Object converters = ReflectionUtils.getField(converterField, conversionService);

		// add a break point and test that converters contains a DomainClassConverter instance
		Assert.assertNotNull("the conversion service should exist", conversionService);
		// assert that the DomainClassConverter has been registered
		Assert.assertTrue(conversionService.canConvert(Object.class, Object.class));
	}

}
