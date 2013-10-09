Steps to reproduce:
* run the application (tested under Tomcat)
* open the root page of the application so that a session is created
* stop Tomcat - observe warning when serializing session
* restart Tomcat - observe error when deserializing session
