## Prerequisites

### Postgres SQL Server

Install Postgres, then initilize and run the server. Something like:

```
brew install postgresql
initdb /usr/local/var/postgres -E utf8
pg_ctl -D /usr/local/var/postgres -l /usr/local/var/postgres/server.log start
```

Create a test user and database:

```
createuser springdemo
createdb bootdemo
psql bootdemo
ALTER USER springdemo WITH PASSWORD 'springdemo';
\q
```

### WildFly 8.1

Install WildFly 8.1 then configure add a postgres module:

```
cd $JBOSS_HOME
mkdir -p modules/org/postgresql/main
wget https://jdbc.postgresql.org/download/postgresql-9.3-1102.jdbc41.jar
mv postgresql-9.3-1102.jdbc41.jar modules/org/postgresql/main
```

`$JBOSS_HOME/modules/org/postgresql/main/module.xml`

```
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="org.postgresql">
	<resources>
		<resource-root path="postgresql-9.3-1102.jdbc41.jar"/>
	</resources>
	<dependencies>
		<module name="javax.api"/>
		<module name="javax.transaction.api"/>
	</dependencies>
</module>
```

## Deployment

The `$JBOSS_HOME/standalone/configuration/standalone-full.xml` is a good starting point,
copy this file to `$JBOSS_HOME/standalone/configuration/standalone-spring-demo.xml`

You need to register a PostgreSQL XA `Driver` and then configure an `xa-datasource`.

Here's a complete listing of the `xa-datasource` contribution to the `datasources`
element, and the `driver` contribution to the `drivers` element to configure a PostgreSQL
DB connection to localhost.

```
<datasources>
	...
	<xa-datasource
			jndi-name="java:jboss/datasources/springdemo"
			pool-name="CrmXADS"
			enabled="true">
		<xa-datasource-property name="url">jdbc:postgresql://localhost:5432/crm</xa-datasource-property>
		<driver>postgres</driver>
		<xa-pool>
			<min-pool-size>10</min-pool-size>
			<max-pool-size>20</max-pool-size>
			<prefill>true</prefill>
		</xa-pool>
		<security>
			<user-name>springdemo</user-name>
			<password>springdemo</password>
		</security>
	</xa-datasource>
	<drivers>
		...
		<driver name="postgres" module="org.postgresql">
			<xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
		</driver>
	</drivers>
</datasources>
```

Run Wildfly with the following command:

```
$JBOSS_HOME/bin/standalone.sh -c standalone-boot-demo.xml
```

Build the app and copy the war to `$JBOSS_HOME/standalone/deployments`

## Replicating the issue

Open a browser to http://localhost:8080/SPR-12118-1.0-SNAPSHOT/ and continually refresh
the page. After a few refreshes things break:

```
09:32:42,668 ERROR [io.undertow.request] (default task-24) UT005023: Exception handling request to /SPR-12118-1.0-SNAPSHOT/: org.springframework.web.util.NestedServletException: Request processing failed; nested exception is javax.persistence.PersistenceException: org.hibernate.exception.GenericJDBCException: Could not open connection
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:973) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:852) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:687) [jboss-servlet-api_3.1_spec-1.0.0.Final.jar:1.0.0.Final]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:790) [jboss-servlet-api_3.1_spec-1.0.0.Final.jar:1.0.0.Final]
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:85) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:61) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at org.wildfly.extension.undertow.security.SecurityContextAssociationHandler.handleRequest(SecurityContextAssociationHandler.java:78)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:113) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:56) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:45) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:61) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:58) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:70) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.security.handlers.SecurityInitialHandler.handleRequest(SecurityInitialHandler.java:76) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at org.wildfly.extension.undertow.security.jacc.JACCContextIdHandler.handleRequest(JACCContextIdHandler.java:61)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:25) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:240) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:227) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler.access$000(ServletInitialHandler.java:73) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:146) [undertow-servlet-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:177) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:727) [undertow-core-1.0.15.Final.jar:1.0.15.Final]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [rt.jar:1.8.0_11]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [rt.jar:1.8.0_11]
	at java.lang.Thread.run(Thread.java:745) [rt.jar:1.8.0_11]
Caused by: javax.persistence.PersistenceException: org.hibernate.exception.GenericJDBCException: Could not open connection
	at org.hibernate.jpa.spi.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1763) [hibernate-entitymanager-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.jpa.spi.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1677) [hibernate-entitymanager-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.jpa.internal.QueryImpl.getSingleResult(QueryImpl.java:524) [hibernate-entitymanager-4.3.6.Final.jar:4.3.6.Final]
	at com.test.wildflytransactions.AccountService.getCount(AccountService.java:41) [classes:]
	at com.test.wildflytransactions.AccountService$$FastClassBySpringCGLIB$$70f25f07.invoke(<generated>) [spring-core-4.1.0.BUILD-SNAPSHOT.jar:]
	at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204) [spring-core-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:717) [spring-aop-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157) [spring-aop-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98) [spring-tx-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:266) [spring-tx-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95) [spring-tx-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179) [spring-aop-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:653) [spring-aop-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at com.test.wildflytransactions.AccountService$$EnhancerBySpringCGLIB$$eea1167c.getCount(<generated>) [spring-core-4.1.0.BUILD-SNAPSHOT.jar:]
	at com.test.wildflytransactions.WebController.test(WebController.java:17) [classes:]
	at sun.reflect.GeneratedMethodAccessor33.invoke(Unknown Source) [:1.8.0_11]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) [rt.jar:1.8.0_11]
	at java.lang.reflect.Method.invoke(Method.java:483) [rt.jar:1.8.0_11]
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215) [spring-web-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132) [spring-web-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:781) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:721) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:943) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:877) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961) [spring-webmvc-4.1.0.BUILD-SNAPSHOT.jar:4.1.0.BUILD-SNAPSHOT]
	... 30 more
Caused by: org.hibernate.exception.GenericJDBCException: Could not open connection
	at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:54) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:126) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:112) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.LogicalConnectionImpl.obtainConnection(LogicalConnectionImpl.java:235) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.LogicalConnectionImpl.getConnection(LogicalConnectionImpl.java:171) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.StatementPreparerImpl.connection(StatementPreparerImpl.java:63) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.StatementPreparerImpl$5.doPrepare(StatementPreparerImpl.java:162) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.StatementPreparerImpl$StatementPreparationTemplate.prepareStatement(StatementPreparerImpl.java:186) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.StatementPreparerImpl.prepareQueryStatement(StatementPreparerImpl.java:160) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.prepareQueryStatement(Loader.java:1884) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.executeQueryStatement(Loader.java:1861) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.executeQueryStatement(Loader.java:1838) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.doQuery(Loader.java:909) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.doQueryAndInitializeNonLazyCollections(Loader.java:354) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.doList(Loader.java:2553) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.doList(Loader.java:2539) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.listIgnoreQueryCache(Loader.java:2369) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.Loader.list(Loader.java:2364) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.loader.hql.QueryLoader.list(QueryLoader.java:496) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.hql.internal.ast.QueryTranslatorImpl.list(QueryTranslatorImpl.java:387) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.query.spi.HQLQueryPlan.performList(HQLQueryPlan.java:231) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.internal.SessionImpl.list(SessionImpl.java:1264) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.internal.QueryImpl.list(QueryImpl.java:103) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.jpa.internal.QueryImpl.list(QueryImpl.java:573) [hibernate-entitymanager-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.jpa.internal.QueryImpl.getSingleResult(QueryImpl.java:495) [hibernate-entitymanager-4.3.6.Final.jar:4.3.6.Final]
	... 54 more
Caused by: java.sql.SQLException: javax.resource.ResourceException: IJ000453: Unable to get managed connection for java:jboss/datasources/bootdemo
	at org.jboss.jca.adapters.jdbc.WrapperDataSource.getConnection(WrapperDataSource.java:154)
	at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:139) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.internal.AbstractSessionImpl$NonContextualJdbcConnectionAccess.obtainConnection(AbstractSessionImpl.java:380) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	at org.hibernate.engine.jdbc.internal.LogicalConnectionImpl.obtainConnection(LogicalConnectionImpl.java:228) [hibernate-core-4.3.6.Final.jar:4.3.6.Final]
	... 75 more
Caused by: javax.resource.ResourceException: IJ000453: Unable to get managed connection for java:jboss/datasources/bootdemo
	at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.getManagedConnection(AbstractConnectionManager.java:440)
	at org.jboss.jca.core.connectionmanager.tx.TxConnectionManagerImpl.getManagedConnection(TxConnectionManagerImpl.java:422)
	at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.allocateConnection(AbstractConnectionManager.java:513)
	at org.jboss.jca.adapters.jdbc.WrapperDataSource.getConnection(WrapperDataSource.java:146)
	... 78 more
Caused by: javax.resource.spi.RetryableUnavailableException: IJ000653: The pool has been shutdown (BootPool,6c15203a)
	at org.jboss.jca.core.connectionmanager.pool.mcp.SemaphoreArrayListManagedConnectionPool.getConnection(SemaphoreArrayListManagedConnectionPool.java:355)
	at org.jboss.jca.core.connectionmanager.pool.AbstractPool.getTransactionNewConnection(AbstractPool.java:534)
	at org.jboss.jca.core.connectionmanager.pool.AbstractPool.getConnection(AbstractPool.java:435)
	at org.jboss.jca.core.connectionmanager.AbstractConnectionManager.getManagedConnection(AbstractConnectionManager.java:379)
	... 81 more
```


