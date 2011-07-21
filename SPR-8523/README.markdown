
Steps to reproduce:

1. run `mvn test`; note BUILD SUCCESSFUL
2. edit src/test/java/org/springframework/issues/ReproTests.java and uncomment the second line in the _never_called() method
3. run `mvn test`; note BUILD FAILED

You'll notice in the pom that tests are being run with

    -javaagent:/path/to/org.springframework.instrument.jar


Workaround: Use compile time weaving instead

1. Repeat steps 2 and 3 above to cause the build to fail
2. copy `pom-compile-time-weaving.xml` to `pom.xml` (you may want to diff these two files first to understand what's changed)
3. run `mvn test`; note BUILD SUCCESSFUL
