package org.springframework.issues;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {

	public void doSomething(@NotNull @Valid final MyBean bean) {
		System.out.println("do something");
	}

	@Async
	public void doSomethingAsync(@NotNull @Valid final MyBean bean) {
		System.out.println("do something async");
	}
}
