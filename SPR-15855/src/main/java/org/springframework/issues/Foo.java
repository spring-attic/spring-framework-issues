package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.generic.ParentGeneric;
import org.springframework.issues.service.ParentService;
import org.springframework.stereotype.Component;

@Component
public class Foo {

	// The parent service with parent generic type is wanted. 
	// But I think a child service with child generic type should also work. 
	@Autowired
	ParentService<ParentGeneric> serv;
	
}
