# SPR-12472

[SPR-12472 Issue on JIRA](https://jira.spring.io/browse/SPR-12472)

## Running the project locally

    mvn clean package cargo:run -Ptomcat8

To debug step by step in your IDE, run:

    mvn clean package cargo:run -Ptomcat8 -Pdebug

And create a debug configuration in your IDE for a remote tomcat server, connecting to port 8000.

## Reproducing the issue

Go to [http://localhost:8080/SPR-12472/issue](http://localhost:8080/SPR-12472/issue) and see that both user-9 and user-10 are
selected, but that many `SELECT` queries were issued in the CONSOLE logs.

A couple of fixes are possible:

* comparing the candidate value `user.id` to a list of selected Ids, see [http://localhost:8080/SPR-12472/ids](http://localhost:8080/SPR-12472/ids)
* using a custom `selected` expression, see [http://localhost:8080/SPR-12472/select](http://localhost:8080/SPR-12472/selec)

Note that with this solution the converter still kicks in for the following case:
[http://localhost:8080/SPR-12472/user/10](http://localhost:8080/SPR-12472/user/10).

