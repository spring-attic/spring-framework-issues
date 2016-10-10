<%-- 
    Document   : index
    Created on : Mar 30, 2010, 2:27:38 PM
    Author     : igilany
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext, org.springframework.context.support.ClassPathXmlApplicationContext,org.trepel.spring.xstream.MarshallTest,java.util.Map.Entry,java.io.File,org.trepel.spring.xstream.Report" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Xstream results</title>
    </head>
    <body>
        <ul>
            <%
            File f = new File("data.xml");
            ApplicationContext appContext =
                    new ClassPathXmlApplicationContext("applicationContext.xml");

            for (Report r : MarshallTest.test(f, appContext)) {
                out.println("<li>" + r.getStatus() + "<ul><br /><li>" + r.getMarshalledObject() + "</li><br /></ul></li>");
            }
            %>
        </ul>
    </body>
</html>
