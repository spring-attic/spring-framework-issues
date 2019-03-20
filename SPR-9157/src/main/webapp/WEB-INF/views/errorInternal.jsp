<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<jsp:text>
	<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> ]]>
</jsp:text>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Spring 3 Converter</title>
</head>
<body>
Error<br/>
<%
LoggerFactory.getLogger("InternalError").error("Exception occured: ", exception);
%>
<%= exception.toString() %> <br/>
</body>
</html>
