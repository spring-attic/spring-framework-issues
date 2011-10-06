package org.springframework.issues;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.web.bind.WebDataBinder;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {
	
	@Test
	public void stringToString() {
		
		TestMap<String, String> source = new TestMap<String, String>();
		source.init();
		source.put("key", "value");
		source.put("key", null);

		TestMapConsumer target = new TestMapConsumer();

		WebDataBinder dataBinder = new WebDataBinder(target, "");
		dataBinder.setConversionService(new DefaultFormattingConversionService());
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue("testMap", source);
		dataBinder.bind(pvs);

		// FallbackObjectToStringConverter for key-value pairs
		
		assertSame(source.keySet().iterator().next(), target.getTestMap().keySet().iterator().next());
		assertSame(source.values().iterator().next(), target.getTestMap().values().iterator().next());
		
		assertTrue(target.getTestMap().isInitialized());
	}

	@Test
	public void numberToNumber() {
		
		TestMap<Integer, Integer> source = new TestMap<Integer, Integer>();
		source.init();
		source.put(new Integer(5), new Integer(6));

		TestMapConsumer target = new TestMapConsumer();

		WebDataBinder dataBinder = new WebDataBinder(target, "");
		dataBinder.setConversionService(new DefaultFormattingConversionService());
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue("testNumberMap", source);
		dataBinder.bind(pvs);

		// NumberToNumber converter for key-value pairs
		
		assertSame(source.keySet().iterator().next(), target.getTestNumberMap().keySet().iterator().next());
		assertSame(source.values().iterator().next(), target.getTestNumberMap().values().iterator().next());
		
		assertTrue(target.getTestNumberMap().isInitialized());
	}

	@Test
	public void integerToInteger() {
		
		TestMap<Integer, Integer> source = new TestMap<Integer, Integer>();
		source.init();
		source.put(new Integer(5), new Integer(6));

		TestMapConsumer target = new TestMapConsumer();

		WebDataBinder dataBinder = new WebDataBinder(target, "");
		dataBinder.setConversionService(new DefaultFormattingConversionService());
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue("testIntegerMap", source);
		dataBinder.bind(pvs);

		// NumberToNumber converter for key-value pairs
		
		assertSame(source.keySet().iterator().next(), target.getTestIntegerMap().keySet().iterator().next());
		assertSame(source.values().iterator().next(), target.getTestIntegerMap().values().iterator().next());
		
		assertTrue(target.getTestIntegerMap().isInitialized());
	}

	@Test
	public void assignableKeyValueParis() {
		
		TestMap<TestBean, TestBean> source = new TestMap<TestBean, TestBean>();
		source.init();
		source.put(new TestBean(), new TestBean());

		TestMapConsumer target = new TestMapConsumer();

		WebDataBinder dataBinder = new WebDataBinder(target, "");
		dataBinder.setConversionService(new DefaultFormattingConversionService());
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.addPropertyValue("testBeanMap", source);
		dataBinder.bind(pvs);

		// NO_OP converter for key-value pairs (no converter
		
		assertSame(source.keySet().iterator().next(), target.getTestBeanMap().keySet().iterator().next());
		assertSame(source.values().iterator().next(), target.getTestBeanMap().values().iterator().next());
		
		assertTrue(target.getTestBeanMap().isInitialized());
	}
	
}
