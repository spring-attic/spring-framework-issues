package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonTestController {

	@RequestMapping(value = "/json/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> test() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", Boolean.TRUE);
		return map;
	}

	@RequestMapping(value = "/json/test2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> test2() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", Boolean.TRUE);
		return map;
	}

	@RequestMapping(value = "/json/test3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> test3() {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("result", Boolean.TRUE);
		return map;
	}

}
