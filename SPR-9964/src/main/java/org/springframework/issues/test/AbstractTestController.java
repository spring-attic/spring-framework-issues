package org.springframework.issues.test;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractTestController<DTO extends Identifiable> {

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody DTO test(@RequestBody DTO dto) {
		return dto;
	}

	@RequestMapping(value = "/testList", method = RequestMethod.POST)
	public @ResponseBody List<DTO> test(@RequestBody List<DTO> dtoList) {
		return dtoList;
	}

	@RequestMapping(value = "/testHttpEntity", method = RequestMethod.POST)
	public @ResponseBody DTO test(HttpEntity<DTO> responseEntity) {
		return responseEntity.getBody();
	}

}
