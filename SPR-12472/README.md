# SPR-12472

[SPR-12472 Issue on JIRA](https://jira.spring.io/browse/SPR-12472)

## Running the project locally

    mvn clean package cargo:run -Ptomcat8

To debug step by step in your IDE, run:

    mvn clean package cargo:run -Ptomcat8 -Pdebug

And create a debug configuration in your IDE for a remote tomcat server, connecting to port 8000.

## Reproducing the issue

Go to [http://localhost:8080/SPR-12472/](http://localhost:8080/SPR-12472/) and see that both user-9 and user-10 are
selected, but that many `SELECT` queries were issued in the CONSOLE logs.

To test a fix, edit `webapp/WEB-INF/views/index.html` and comment/uncomment the forms to try selecting with Ids. Note
that with this solution the converter still kicks in for the following case:
[http://localhost:8080/SPR-12472/user/10](http://localhost:8080/SPR-12472/user/10).

