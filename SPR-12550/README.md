## Repro project for SPR-12550

See issue [SPR-12550 on jira](https://jira.spring.io/browse/SPR-12550).

To launch this project, use:

    mvn clean package cargo:run -Ptomcat8

A couple of endpoints are available for testing:

* http://localhost:8080/SPR-12550/main/home
* http://localhost:8080/SPR-12550/main/forward