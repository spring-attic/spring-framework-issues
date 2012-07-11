package org.springframework.issues;

import java.util.concurrent.Future;

public interface AsyncProcessInterface {

	
	public abstract Future<String> findBalanceAsync(final String account);
}
