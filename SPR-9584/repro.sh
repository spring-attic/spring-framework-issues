# per instructions at https://jira.springsource.org/browse/SPR-9584

javac -classpath ../../spring-framework/spring-beans/build/libs/spring-beans-3.2.0.BUILD-SNAPSHOT.jar:../../spring-framework/spring-core/build/libs/spring-core-3.2.0.BUILD-SNAPSHOT.jar *.java

for i in {1..1000}; do
    java -cp ../../spring-framework/spring-beans/build/libs/spring-beans-3.2.0.BUILD-SNAPSHOT.jar:../../spring-framework/spring-core/build/libs/spring-core-3.2.0.BUILD-SNAPSHOT.jar:/Users/cbeams/.m2/repository/commons-logging/commons-logging/1.1.1/commons-logging-1.1.1.jar:. Main 50
done
