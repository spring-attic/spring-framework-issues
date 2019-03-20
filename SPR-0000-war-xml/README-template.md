## Spring MVC project with XML config

This is a simple template for creating issue reproduction projects per
the [README in the root of this repository](https://github.com/spring-projects/spring-framework-issues#readme).
Please review that document before starting.

As described at the link above, do not edit this project directly! Rather
use the `./create-repro-project.sh` script to create a fresh copy to
a new directory having the same name as the JIRA issue you're trying
to reproduce and edit from there.

## Deploying

It is possible to deploy your application directly from the command-line
using maven. See the next two sections on Cargo and Jetty.

### Cargo

You can deploy with the [Cargo Maven plugin](https://cargo.codehaus.org/) which
supports a wide [range of servers](https://cargo.codehaus.org/Containers).
The required command is `mvn package cargo:run`.

By default Cargo is configured to start with `Tomcat 8` but you can easily
edit the plugin settings in `pom.xml` to switch to a different server
and version. The pom.xml  or to switch to debug settings.

### Jetty

You can also deploy with the
[Jetty Maven plugin](https://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html).
The required command is `mvn jetty:run` or `mvnDebug jetty:run`.

## Logging

This project contains a `log4j.properties` file in `src/main/resources` that you
may wish to configure to emit more detailed logging.  The root logger is set to
`INFO` and a custom `org.springframework.web` logger is set to `DEBUG`.
