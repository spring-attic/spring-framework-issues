## SPR-10441

This sample project reproduces the exception described in [SPR-10441](https://jira.springsource.org/browse/SPR-10441)

To reproduce, follow those steps:

1. run `mvn clean install`
1. Execute the following command to validate the sample app works fine:
`java -cp "spr-10441-b/target/spr-10441-b-1.0-SNAPSHOT.jar:spr-10441-b/target/lib/*" org.springframework.issues.SampleApp`
1. Remove the `spr-10441-a` project that holds the annotation
`rm spr-10441-b/target/lib/spr-10441-a-1.0-SNAPSHOT.jar`
1. Runs the application again to reproduce the issue:
`java -cp "spr-10441-b/target/spr-10441-b-1.0-SNAPSHOT.jar:spr-10441-b/target/lib/*" org.springframework.issues.SampleApp`