package org.springframework.issues;

import java.util.List;

public interface MyService {
	
	List<Message> someTransactionalMethod();
}
