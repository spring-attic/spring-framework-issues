# Repro project for SPR-15855

RUN:

	Just run ReproTests, and you will see the error.

Problem:
	
	The Foo class want a dependency with type "ParentService<ParentGeneric>", 
	but only candidate with type ChildService<ChildGeneric> is supplied. (The ChildService is the candidate) 
	I think this should work, (a generic covariance type should be accepted), but spring refused it.