# Problem sample

run with

    $ mvn jetty:run

request with

    $ curl localhost:8080

Exception occurs like:

    2014-09-21 17:11:20,204 DEBUG [org.springframework.web.servlet.DispatcherServlet] - <Could not complete request>
    java.lang.UnsupportedOperationException
            at java.util.Collections$UnmodifiableMap.put(Collections.java:1517)
            at org.springframework.http.HttpHeaders.set(HttpHeaders.java:869)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.setProtoHeader(ProtobufHttpMessageConverter.java:196)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.writeInternal(ProtobufHttpMessageConverter.java:182)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.writeInternal(ProtobufHttpMessageConverter.java:60)
            at org.springframework.http.converter.AbstractHttpMessageConverter.write(AbstractHttpMessageConverter.java:208)
            at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:153)
            at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:97)
            at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(RequestResponseBodyMethodProcessor.java:202)
            at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:71)
            at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:122)
            at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:781)
            at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:721)
            at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
            at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:943)
            at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:877)
            at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
            at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:852)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:687)
            at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
            at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:717)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1644)
            at org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter.doFilter(WebSocketUpgradeFilter.java:171)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1615)
            at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:550)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
            at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:568)
            at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:221)
            at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1112)
            at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:479)
            at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:183)
            at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1046)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
            at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:199)
            at org.eclipse.jetty.server.handler.HandlerCollection.handle(HandlerCollection.java:109)
            at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:97)
            at org.eclipse.jetty.server.Server.handle(Server.java:459)
            at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:281)
            at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:232)
            at org.eclipse.jetty.io.AbstractConnection$1.run(AbstractConnection.java:505)
            at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:607)
            at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:536)
            at java.lang.Thread.run(Thread.java:745)
    2014-09-21 17:11:20.290:WARN:oejs.ServletHandler:qtp54176060-15: 
    org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.UnsupportedOperationException
            at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:973)
            at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:852)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:687)
            at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
            at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:717)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1644)
            at org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter.doFilter(WebSocketUpgradeFilter.java:171)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1615)
            at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:550)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
            at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:568)
            at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:221)
            at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1112)
            at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:479)
            at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:183)
            at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1046)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
            at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:199)
            at org.eclipse.jetty.server.handler.HandlerCollection.handle(HandlerCollection.java:109)
            at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:97)
            at org.eclipse.jetty.server.Server.handle(Server.java:459)
            at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:281)
            at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:232)
            at org.eclipse.jetty.io.AbstractConnection$1.run(AbstractConnection.java:505)
            at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:607)
            at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:536)
            at java.lang.Thread.run(Thread.java:745)
    Caused by: 
    java.lang.UnsupportedOperationException
            at java.util.Collections$UnmodifiableMap.put(Collections.java:1517)
            at org.springframework.http.HttpHeaders.set(HttpHeaders.java:869)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.setProtoHeader(ProtobufHttpMessageConverter.java:196)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.writeInternal(ProtobufHttpMessageConverter.java:182)
            at org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter.writeInternal(ProtobufHttpMessageConverter.java:60)
            at org.springframework.http.converter.AbstractHttpMessageConverter.write(AbstractHttpMessageConverter.java:208)
            at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:153)
            at org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor.writeWithMessageConverters(AbstractMessageConverterMethodProcessor.java:97)
            at org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.handleReturnValue(RequestResponseBodyMethodProcessor.java:202)
            at org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite.handleReturnValue(HandlerMethodReturnValueHandlerComposite.java:71)
            at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:122)
            at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:781)
            at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:721)
            at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
            at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:943)
            at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:877)
            at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
            at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:852)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:687)
            at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
            at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
            at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:717)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1644)
            at org.eclipse.jetty.websocket.server.WebSocketUpgradeFilter.doFilter(WebSocketUpgradeFilter.java:171)
            at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1615)
            at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:550)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
            at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:568)
            at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:221)
            at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1112)
            at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:479)
            at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:183)
            at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1046)
            at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
            at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:199)
            at org.eclipse.jetty.server.handler.HandlerCollection.handle(HandlerCollection.java:109)
            at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:97)
            at org.eclipse.jetty.server.Server.handle(Server.java:459)
            at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:281)
            at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:232)
            at org.eclipse.jetty.io.AbstractConnection$1.run(AbstractConnection.java:505)
            at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:607)
            at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:536)
            at java.lang.Thread.run(Thread.java:745)


# Fixed sample

run with

    $ mvn jetty:run -Dfixed

request with

    $ curl localhost:8080
    
    John Doe�	jdoe@example.com"
    
    555-4321