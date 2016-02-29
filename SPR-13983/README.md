To reproduce the issue:
 - http://localhost:8080/json/test : output OK {"result":true}
 - http://localhost:8080/html/test
 - http://localhost:8080/json/test : output NOK {"result":true}{"result":true}
 
The issue is reproducible only when RequestMappingHandlerAdapter.setSynchronizeOnSession(true)
is invoked (cf. SynchronizeOnSessionPostProcessor) with Spring Framework 4.2.5.

Works fine with Spring Framework 4.2.4.