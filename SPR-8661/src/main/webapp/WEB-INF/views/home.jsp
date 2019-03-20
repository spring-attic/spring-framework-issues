<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Home</h1>

  <form:form modelAttribute="javaBean">
  	<p><form:hidden path="hiddenText" disabled="true" /></p>
  	<p><form:input path="text" disabled="true" /></p>
  	<p><input type="submit"></p>
  </form:form>
  
  <form:form modelAttribute="javaBean">
  	<p><form:hidden path="hiddenText" disabled="false" /> <!-- disabled is written --> </p>
  	<p><form:input path="text" disabled="false" /> <!-- disabled not written --> </p>
  	<p><input type="submit"></p>
  </form:form>

</body>
</html>
