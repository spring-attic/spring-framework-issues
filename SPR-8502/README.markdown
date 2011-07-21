Steps to reproduce:

1. run `mvn test`; note BUILD SUCCESSFUL
2. edit src/test/java/poc/configurable/ServiceInjectionTests.java and uncomment `someMethod(Entity)`
3. run `mvn test`; note BUILD FAILED

You'll notice in the pom that tests are being run with

    -javaagent:/path/to/org.springframework.instrument.jar

Examine the small application and the assertion in ServiceInjectionTests and you'll see that Entity is a @Configurable and uses @Autowired to receive injection of a Service.  The assertion shows that this injection fails when `someMethod(Entity)` is present in ServiceInjectionTests.  If this method is commented out or placed within any other type in the application, the injection occurs as expected and the test passes.

See https://jira.springsource.org/browse/SPR-8502 for analysis of the causes of this problem
