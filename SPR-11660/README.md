## Spring MVC project with Java config

This is a simple template for creating issue reproduction projects per
the [README in the root of this repository](https://github.com/spring-projects/spring-framework-issues#readme).
Please review that document before starting.

As described at the link above, do not edit this project directly! Rather
use the `./create-repro-project.sh` script to create a fresh copy to
a new directory having the same name as the JIRA issue you're trying
to reproduce and edit from there.

## Deploying

It is possible to deploy your application directly from the command-line
using maven. You can use either [cargo](https://cargo.codehaus.org/) or
the [jetty plugin](https://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)
to run on a wide range of containers.

### Cargo

By default Cargo is configured to start `Tomcat7` and can be invoked by
running `mvn package cargo:run`. Cargo can also run a [wide range of other
containers](https://cargo.codehaus.org/Containers) and you can easily add
yours by editing the `pom.xml`. For instance, a `tomcat8` profile
has been added and can be invoked via `mvn package cargo:run -Ptomcat8`.

### Jetty

To deploy your application to jetty9, simply invoke `mvn jetty:run`. It
is possible to tune the exact jetty9 version you want to use by specifying
the version of the command line, e.g. `mvn jetty:run -Djetty.version=9.0.6.v20130930`

To run a different version of jetty, please fallback to cargo as the
coordinates of the maven plugin have changed. A sample `jetty8` profile is
created for reference and can be tuned to suit your needs. To deploy your
sample application to jetty8 run `mvn cargo:run -Pjetty8`

## Logging

This project contains a `log4j.properties` file in `src/main/resources` that you
may wish to configure to emit more detailed logging.  The root logger is set to
`INFO` and a custom `org.springframework.web` logger is set to `DEBUG`.
