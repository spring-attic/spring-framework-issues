## SPR-13639

Run this project with `mvn package cargo:run -DskipTests` then run the RestTemplateIntegrationTest
class in your IDE or on the command line with `mvn test`.

### Cargo

You can deploy with the [Cargo Maven plugin](https://cargo.codehaus.org/) which
supports a wide [range of servers](https://cargo.codehaus.org/Containers).
The required command is `mvn package cargo:run`.

By default Cargo is configured to start with `Tomcat 8` but you can easily
edit the plugin settings in `pom.xml` to switch to a different server
and version. The pom.xml  or to switch to debug settings.


## Logging

This project contains a `log4j.properties` file in `src/main/resources` that you
may wish to configure to emit more detailed logging.  The root logger is set to
`INFO` and a custom `org.springframework.web` logger is set to `DEBUG`.
