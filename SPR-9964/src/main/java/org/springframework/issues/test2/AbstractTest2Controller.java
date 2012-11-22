package org.springframework.issues.test2;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractTest2Controller<DTO extends Identifiable2<T>, T> {

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public @ResponseBody DTO test(@RequestBody DTO dto) {
		return dto;
	}

	@RequestMapping(value = "/test2List", method = RequestMethod.POST)
	public @ResponseBody List<DTO> test(@RequestBody List<DTO> dtoList) {
		return dtoList;
	}

	@RequestMapping(value = "/test2HttpEntity", method = RequestMethod.POST)
	public @ResponseBody DTO test(HttpEntity<DTO> responseEntity) {
		return responseEntity.getBody();
	}

}
