package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.generic.ParentGeneric;
import org.springframework.issues.service.ParentService;
import org.springframework.stereotype.Component;

@Component
public class Foo {

	// A dependency with type "ParentService<ParentGeneric>", 
	// but only candidate with type ChildService<ChildGeneric> is supplied.(The ChildService is the candidate) 
	// I think this should work, (a generic covariance type should be accepted), but spring refused it.
	@Autowired
	ParentService<ParentGeneric> serv;
	
}
