This projects is meant to showcase this issue :

https://jira.spring.io/browse/SPR-15921

Test scenario : as is, the project is using spring-web 4.3.9.RELEASE via boot 1.5.4.RELEASE

* Run the app, go to http://localhost:8080/edit and submit the form : there is no null pointer, in FormController.update one can check that SimpleBean is correctly populated with the content of the form.
* Migrate to Spring boot 1.5.6.RELEASE via the POM entries on 		<artifactId>spring-boot-starter-parent</artifactId> , 			<artifactId>spring-boot-starter-thymeleaf</artifactId>, etc.
* Clean and refresh all the artifacts, run the appl, go to http://localhost:8080/edit and submit the form : there is a null pointer, the SimpleBean object is empty

The problem according to me traces to this commit : https://github.com/spring-projects/spring-framework/commit/8d743181daf6120c34d1c7778ea5231a78d72d7b and that change on HttpPutFormContentFilter :

String[] queryParam = (super.getQueryString() != null ? super.getParameterValues(name) : null);




