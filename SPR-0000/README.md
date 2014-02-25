## Simple Spring application template

This is a simple template for creating issue reproduction projects per
the [README in the root of this repository](https://github.com/spring-projects/spring-framework-issues#readme).
Please read that document completely before starting.

As described at the link above, do not edit this project directly! Rather
use the `./create-repro-project.sh` script to create a fresh copy to
a new directory having the same name as the JIRA issue you're trying
to reproduce and edit from there.

Both Gradle (`build.gradle`) and Maven (`pom.xml`) build scripts are
included for your convenience and choice.  Once you've created your
copy of this directory, delete whichever build script you don't wish
to use, and then edit the remaining one to suit your needs.

Note that this project contains a `log4j.properties` file in
`src/test/resources` that you may wish to configure to emit more
detailed logging. The log level for `org.springframework` is set
to `WARN` by default.
