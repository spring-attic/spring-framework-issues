
Steps to reproduce:

1. run `mvn test`; note BUILD SUCCESSFUL
2. edit src/test/java/org/springframework/issues/ReproTests.java and uncomment the second line in the _never_called() method
3. run `mvn test`; note BUILD FAILED

You'll notice in the pom that tests are being run with

    -javaagent:/path/to/org.springframework.instrument.jar

