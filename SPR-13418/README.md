# Repro project for SPR-0000-war-java

The project will be available at: http://localhost:8080/SPR-0000-war-java/

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

You can remote debug the application, in your IDE, by using the following command:
 `mvn package cargo:run -Ptomcat8 -Pdebug`. Note that you can customize the debug
 port used with the `cargo.jvm.debug.port` maven property.

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


