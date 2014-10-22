<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Home</h1>
  <h2>Languages</h2>
  <ul>
      <li><a href="?language=es">Spanish</a></li>
      <li><a href="?language=en">English</a></li>
      <li><a href="?language=zh_CN">Chinese</a></li>
  </ul>
  <p>Message shown directly on the jsp using spring:message tag: <spring:message code="welcome.springmvc" text="default text" /></p>
  <p>Message shown directly on the jsp using spring:message tag and htmlEscape=true : <spring:message code="welcome.springmvc"  htmlEscape="true" text="default text" /></p>
  <p>Current Locale : ${pageContext.response.locale}</p>
</body>
<script>
    var htmlEscaped = '<spring:message code="welcome.springmvc" htmlEscape="true" text="default text" />';
    console.log("htmlEscape=true", htmlEscaped);

    var rawMessage = '<spring:message code="welcome.springmvc" text="default text" />';
    console.log("rawMessage", rawMessage);
</script>
</html>