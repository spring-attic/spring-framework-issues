Simple reporducer for https://jira.springsource.org/browse/SPR-11147

You have to configure your setting.xml for access to spring milestone repo if using Spring 4.0.0.RC2.
This should work with both JBoss AS7 and Tomcat 7.

to create war using Spring 4:
mvn clean package

to create war using Spring 3.2:
mvn clean package -Pspring-3.2
