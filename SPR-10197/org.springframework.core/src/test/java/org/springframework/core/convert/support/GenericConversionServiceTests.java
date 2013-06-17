/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.convert.support;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.io.DescriptiveResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

/**
 * @author Keith Donald
 * @author Juergen Hoeller
 */
public class GenericConversionServiceTests {

	private GenericConversionService conversionService = new GenericConversionService();

	@Test
	public void canConvert() {
		assertFalse(conversionService.canConvert(String.class, Integer.class));
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		assertTrue(conversionService.canConvert(String.class, Integer.class));		
	}
	
	@Test
	public void canConvertAssignable() {
		assertTrue(conversionService.canConvert(String.class, String.class));
		assertTrue(conversionService.canConvert(Integer.class, Number.class));
		assertTrue(conversionService.canConvert(boolean.class, boolean.class));
		assertTrue(conversionService.canConvert(boolean.class, Boolean.class));
	}
	
	@Test
	public void canConvertIllegalArgumentNullTargetType() {
		try {
			assertFalse(conversionService.canConvert(String.class, null));
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			
		}
		try {
			assertFalse(conversionService.canConvert(TypeDescriptor.valueOf(String.class), null));
			fail("Should have failed");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	public void canConvertNullSourceType() {
		assertTrue(conversionService.canConvert(null, Integer.class));
		assertTrue(conversionService.canConvert(null, TypeDescriptor.valueOf(Integer.class)));
	}
	
	@Test
	public void convert() {
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		assertEquals(new Integer(3), conversionService.convert("3", Integer.class));
	}

	@Test
	public void convertNullSource() {
		assertEquals(null, conversionService.convert(null, Integer.class));
	}

	@Test(expected=ConversionFailedException.class)
	public void convertNullSourcePrimitiveTarget() {
		assertEquals(null, conversionService.convert(null, int.class));
	}

	@Test(expected=ConversionFailedException.class)
	public void convertNullSourcePrimitiveTargetTypeDescriptor() {
		conversionService.convert(null, TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(int.class));
	}

	@Test(expected=IllegalArgumentException.class)
	public void convertNotNullSourceNullSourceTypeDescriptor() {
		conversionService.convert("3", null, TypeDescriptor.valueOf(int.class));
	}

	@Test
	public void convertAssignableSource() {
		assertEquals(Boolean.FALSE, conversionService.convert(false, boolean.class));
		assertEquals(Boolean.FALSE, conversionService.convert(false, Boolean.class));
	}

	@Test
	public void converterNotFound() {
		try {
			conversionService.convert("3", Integer.class);
			fail("Should have thrown an exception");
		}
		catch (ConverterNotFoundException e) {
		}
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void addConverterNoSourceTargetClassInfoAvailable() {
		try {
			conversionService.addConverter(new Converter() {
				public Object convert(Object source) {
					return source;
				}
			});
			fail("Should have failed");
		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void sourceTypeIsVoid() {
		GenericConversionService conversionService = new GenericConversionService();
		assertFalse(conversionService.canConvert(void.class, String.class));
	}

	@Test
	public void targetTypeIsVoid() {
		GenericConversionService conversionService = new GenericConversionService();
		assertFalse(conversionService.canConvert(String.class, void.class));
	}

	@Test
	public void convertNull() {
		assertNull(conversionService.convert(null, Integer.class));
	}

	@Test(expected=IllegalArgumentException.class)
	public void convertNullTargetClass() {
		assertNull(conversionService.convert("3", (Class<?>) null));
		assertNull(conversionService.convert("3", TypeDescriptor.valueOf(String.class), null));
	}

	@Test(expected=IllegalArgumentException.class)
	public void convertNullTypeDescriptor() {
		assertNull(conversionService.convert("3", TypeDescriptor.valueOf(String.class), null));
	}

	@Test(expected=IllegalArgumentException.class)
	public void convertWrongSourceTypeDescriptor() {
		conversionService.convert("3", TypeDescriptor.valueOf(Integer.class), TypeDescriptor.valueOf(Long.class));
	}

	@Test
	public void convertWrongTypeArgument() {
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		try {
			conversionService.convert("BOGUS", Integer.class);
			fail("Should have failed");
		}
		catch (ConversionFailedException e) {

		}
	}

	@Test
	public void convertSuperSourceType() {
		conversionService.addConverter(new Converter<CharSequence, Integer>() {
			public Integer convert(CharSequence source) {
				return Integer.valueOf(source.toString());
			}
		});
		Integer result = conversionService.convert("3", Integer.class);
		assertEquals(new Integer(3), result);
	}

	// SPR-8718
	
	@Test(expected=ConverterNotFoundException.class)
	public void convertSuperTarget() {
		conversionService.addConverter(new ColorConverter());
		conversionService.convert("#000000", SystemColor.class);
	}

	public class ColorConverter implements Converter<String, Color> {
		public Color convert(String source) { if (!source.startsWith("#")) source = "#" + source; return Color.decode(source); }
	}

	@Test
	public void convertObjectToPrimitive() {
		assertFalse(conversionService.canConvert(String.class, boolean.class));
		conversionService.addConverter(new StringToBooleanConverter());
		assertTrue(conversionService.canConvert(String.class, boolean.class));
		Boolean b = conversionService.convert("true", boolean.class);
		assertEquals(Boolean.TRUE, b);
		assertTrue(conversionService.canConvert(TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(boolean.class)));
		b = (Boolean) conversionService.convert("true", TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(boolean.class));
		assertEquals(Boolean.TRUE, b);
	}

	@Test
	public void convertObjectToPrimitiveViaConverterFactory() {
		assertFalse(conversionService.canConvert(String.class, int.class));
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		assertTrue(conversionService.canConvert(String.class, int.class));		
		Integer three = conversionService.convert("3", int.class);
		assertEquals(3, three.intValue());
	}
	
	@Test
	public void genericConverterDelegatingBackToConversionServiceConverterNotFound() {
		conversionService.addConverter(new ObjectToArrayConverter(conversionService));
		assertFalse(conversionService.canConvert(String.class, Integer[].class));
		try {
			conversionService.convert("3,4,5", Integer[].class);
			fail("should have failed");
		} catch (ConverterNotFoundException e) {
		}
	}

	@Test
	public void testListToIterableConversion() {
		GenericConversionService conversionService = new GenericConversionService();
		List<Object> raw = new ArrayList<Object>();
		raw.add("one");
		raw.add("two");
		Object converted = conversionService.convert(raw, Iterable.class);
		assertSame(raw, converted);
	}

	@Test
	public void testListToObjectConversion() {
		GenericConversionService conversionService = new GenericConversionService();
		List<Object> raw = new ArrayList<Object>();
		raw.add("one");
		raw.add("two");
		Object converted = conversionService.convert(raw, Object.class);
		assertSame(raw, converted);
	}

	@Test
	public void testMapToObjectConversion() {
		GenericConversionService conversionService = new GenericConversionService();
		Map<Object, Object> raw = new HashMap<Object, Object>();
		raw.put("key", "value");
		Object converted = conversionService.convert(raw, Object.class);
		assertSame(raw, converted);
	}

	@Test
	public void testInterfaceToString() {
		GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new MyBaseInterfaceConverter());
		conversionService.addConverter(new ObjectToStringConverter());
		Object converted = conversionService.convert(new MyInterfaceImplementer(), String.class);
		assertEquals("RESULT", converted);
	}

	@Test
	public void testInterfaceArrayToStringArray() {
		GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new MyBaseInterfaceConverter());
		conversionService.addConverter(new ArrayToArrayConverter(conversionService));
		String[] converted = conversionService.convert(new MyInterface[] {new MyInterfaceImplementer()}, String[].class);
		assertEquals("RESULT", converted[0]);
	}

	@Test
	public void testObjectArrayToStringArray() {
		GenericConversionService conversionService = new GenericConversionService();
		conversionService.addConverter(new MyBaseInterfaceConverter());
		conversionService.addConverter(new ArrayToArrayConverter(conversionService));
		String[] converted = conversionService.convert(new MyInterfaceImplementer[] {new MyInterfaceImplementer()}, String[].class);
		assertEquals("RESULT", converted[0]);
	}

	@Test
	public void testStringArrayToResourceArray() {
		GenericConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new MyStringArrayToResourceArrayConverter());
		Resource[] converted = conversionService.convert(new String[] {"x1", "z3"}, Resource[].class);
		assertEquals(2, converted.length);
		assertEquals("1", converted[0].getDescription());
		assertEquals("3", converted[1].getDescription());
	}

	@Test
	public void testStringArrayToIntegerArray() {
		GenericConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new MyStringArrayToIntegerArrayConverter());
		Integer[] converted = conversionService.convert(new String[] {"x1", "z3"}, Integer[].class);
		assertEquals(2, converted.length);
		assertEquals(1, converted[0].intValue());
		assertEquals(3, converted[1].intValue());
	}

	@Test
	public void testStringToIntegerArray() {
		GenericConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new MyStringToIntegerArrayConverter());
		Integer[] converted = conversionService.convert("x1,z3", Integer[].class);
		assertEquals(2, converted.length);
		assertEquals(1, converted[0].intValue());
		assertEquals(3, converted[1].intValue());
	}

	@Test
	public void testWildcardMap() throws Exception {
		GenericConversionService conversionService = new DefaultConversionService();
		Map<String, String> input = new LinkedHashMap<String, String>();
		input.put("key", "value");
		Object converted = conversionService.convert(input, TypeDescriptor.forObject(input), new TypeDescriptor(getClass().getField("wildcardMap")));
		assertEquals(input, converted);
	}

	@Test
	public void testListOfList() {
		GenericConversionService service = new DefaultConversionService();
		List<String> list1 = Arrays.asList("Foo", "Bar");
		List<String> list2 = Arrays.asList("Baz", "Boop");
		@SuppressWarnings("unchecked")
		List<List<String>> list = Arrays.asList(list1, list2);
		String result = service.convert(list, String.class);
		assertNotNull(result);
		assertEquals("Foo,Bar,Baz,Boop", result);
	}

	@Test
	public void testStringToString() {
		GenericConversionService service = new DefaultConversionService();
		String value = "myValue";
		String result = service.convert(value, String.class);
		assertSame(value, result);
	}

	@Test
	public void testStringToObject() {
		GenericConversionService service = new DefaultConversionService();
		String value = "myValue";
		Object result = service.convert(value, Object.class);
		assertSame(value, result);
	}

	@Test
	public void testIgnoreCopyConstructor() {
		GenericConversionService service = new DefaultConversionService();
		WithCopyConstructor value = new WithCopyConstructor();
		Object result = service.convert(value, WithCopyConstructor.class);
		assertSame(value, result);
	}

	@Test
	public void testPerformance1() {
		GenericConversionService conversionService = new DefaultConversionService();
		StopWatch watch = new StopWatch("integer->string conversionPerformance");
		watch.start("convert 4,000,000 with conversion service");
		for (int i = 0; i < 4000000; i++) {
			conversionService.convert(3, String.class);
		}
		watch.stop();
		watch.start("convert 4,000,000 manually");
		for (int i = 0; i < 4000000; i++) {
			new Integer(3).toString();
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
	}
	
	@Test
	public void testPerformance2() throws Exception {
		GenericConversionService conversionService = new DefaultConversionService();
		StopWatch watch = new StopWatch("list<string> -> list<integer> conversionPerformance");
		watch.start("convert 4,000,000 with conversion service");
		List<String> source = new LinkedList<String>();
		source.add("1");
		source.add("2");
		source.add("3");
		TypeDescriptor td = new TypeDescriptor(getClass().getField("list"));
		for (int i = 0; i < 1000000; i++) {
			conversionService.convert(source, TypeDescriptor.forObject(source), td);
		}
		watch.stop();
		watch.start("convert 4,000,000 manually");
		for (int i = 0; i < 4000000; i++) {
			List<Integer> target = new ArrayList<Integer>(source.size());
			for (String element : source) {
				target.add(Integer.valueOf(element));
			}
		}
		watch.stop();		
		System.out.println(watch.prettyPrint());
	}

	public static List<Integer> list;

	@Test
	public void testPerformance3() throws Exception {
		GenericConversionService conversionService = new DefaultConversionService();
		StopWatch watch = new StopWatch("map<string, string> -> map<string, integer> conversionPerformance");
		watch.start("convert 4,000,000 with conversion service");
		Map<String, String> source = new HashMap<String, String>();
		source.put("1", "1");
		source.put("2", "2");
		source.put("3", "3");
		TypeDescriptor td = new TypeDescriptor(getClass().getField("map"));		
		for (int i = 0; i < 1000000; i++) {
			conversionService.convert(source, TypeDescriptor.forObject(source), td);
		}
		watch.stop();
		watch.start("convert 4,000,000 manually");
		for (int i = 0; i < 4000000; i++) {
			Map<String, Integer> target = new HashMap<String, Integer>(source.size());
			for (Map.Entry<String, String> entry : source.entrySet()) {
				target.put(entry.getKey(), Integer.valueOf(entry.getValue()));
			}
		}
		watch.stop();		
		System.out.println(watch.prettyPrint());
	}
	
	public static Map<String, Integer> map;

	@Test
	public void emptyListToArray() throws Exception {
		conversionService.addConverter(new CollectionToArrayConverter(conversionService));
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		List<String> list = new ArrayList<String>();
		TypeDescriptor sourceType = TypeDescriptor.forObject(list);
		TypeDescriptor targetType = TypeDescriptor.valueOf(String[].class);
		assertTrue(conversionService.canConvert(sourceType, targetType));
		assertEquals(0, ((String[])conversionService.convert(list, sourceType, targetType)).length);
	}

	@Test
	public void emptyListToObject() throws Exception {
		conversionService.addConverter(new CollectionToObjectConverter(conversionService));
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		List<String> list = new ArrayList<String>();
		TypeDescriptor sourceType = TypeDescriptor.forObject(list);
		TypeDescriptor targetType = TypeDescriptor.valueOf(Integer.class);
		assertTrue(conversionService.canConvert(sourceType, targetType));
		assertNull(conversionService.convert(list, sourceType, targetType));
	}

	private interface MyBaseInterface {

	}


	private interface MyInterface extends MyBaseInterface {

	}


	private static class MyInterfaceImplementer implements MyInterface {

	}


	private static class MyBaseInterfaceConverter implements Converter<MyBaseInterface, String> {

		public String convert(MyBaseInterface source) {
			return "RESULT";
		}
	}


	private static class MyStringArrayToResourceArrayConverter implements Converter<String[], Resource[]>	{

		public Resource[] convert(String[] source) {
			Resource[] result = new Resource[source.length];
			for (int i = 0; i < source.length; i++) {
				result[i] = new DescriptiveResource(source[i].substring(1));
			}
			return result;
		}
	}


	private static class MyStringArrayToIntegerArrayConverter implements Converter<String[], Integer[]>	{

		public Integer[] convert(String[] source) {
			Integer[] result = new Integer[source.length];
			for (int i = 0; i < source.length; i++) {
				result[i] = Integer.parseInt(source[i].substring(1));
			}
			return result;
		}
	}


	private static class MyStringToIntegerArrayConverter implements Converter<String, Integer[]>	{

		public Integer[] convert(String source) {
			String[] srcArray = StringUtils.commaDelimitedListToStringArray(source);
			Integer[] result = new Integer[srcArray.length];
			for (int i = 0; i < srcArray.length; i++) {
				result[i] = Integer.parseInt(srcArray[i].substring(1));
			}
			return result;
		}
	}


	public static class WithCopyConstructor {

		public WithCopyConstructor() {
		}

		public WithCopyConstructor(WithCopyConstructor value) {
		}
	}


	public static Map<String, ?> wildcardMap;

	@Test
	public void stringToArrayCanConvert() {
		conversionService.addConverter(new StringToArrayConverter(conversionService));
		assertFalse(conversionService.canConvert(String.class, Integer[].class));
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		assertTrue(conversionService.canConvert(String.class, Integer[].class));
	}
	
	@Test
	public void stringToCollectionCanConvert() throws Exception {
		conversionService.addConverter(new StringToCollectionConverter(conversionService));
		assertTrue(conversionService.canConvert(String.class, Collection.class));
		TypeDescriptor targetType = new TypeDescriptor(getClass().getField("stringToCollection"));
		assertFalse(conversionService.canConvert(TypeDescriptor.valueOf(String.class), targetType));		
		conversionService.addConverterFactory(new StringToNumberConverterFactory());
		assertTrue(conversionService.canConvert(TypeDescriptor.valueOf(String.class), targetType));		
	}
	
	public Collection<Integer> stringToCollection;
	
	@Test
	public void testConvertiblePairsInSet() throws Exception {
		Set<GenericConverter.ConvertiblePair> set = new HashSet<GenericConverter.ConvertiblePair>();
		set.add(new GenericConverter.ConvertiblePair(Number.class, String.class));
		assert set.contains(new GenericConverter.ConvertiblePair(Number.class, String.class));
	}

	@Test
	public void testConvertiblePairEqualsAndHash() throws Exception {
		GenericConverter.ConvertiblePair pair = new GenericConverter.ConvertiblePair(Number.class, String.class);
		GenericConverter.ConvertiblePair pairEqual = new GenericConverter.ConvertiblePair(Number.class, String.class);
		assertEquals(pair, pairEqual);
		assertEquals(pair.hashCode(), pairEqual.hashCode());
	}

	@Test
	public void testConvertiblePairDifferentEqualsAndHash() throws Exception {
		GenericConverter.ConvertiblePair pair = new GenericConverter.ConvertiblePair(Number.class, String.class);
		GenericConverter.ConvertiblePair pairOpposite = new GenericConverter.ConvertiblePair(String.class, Number.class);
		assertFalse(pair.equals(pairOpposite));
		assertFalse(pair.hashCode() == pairOpposite.hashCode());
	}

}
