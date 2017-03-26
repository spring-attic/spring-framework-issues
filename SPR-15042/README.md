## Scope Bugs

./gradlew clean build

scopedemo1, Spring 5.0.0.BUILD-SNAPSHOT, Boot 2.0.0.BUILD-SNAPSHOT
Caused by: java.lang.IllegalStateException: Cannot create scoped proxy for bean 'scopedTarget.myObject': Target type could not be determined at the time of proxy creation.

scopedemo2, Spring 4.3.3, Boot 1.4.1
OK

scopedemo3, Spring 4.3.4, Boot 1.4.2
Caused by: java.lang.IllegalStateException: Cannot create scoped proxy for bean 'scopedTarget.myObject': Target type could not be determined at the time of proxy creation.

