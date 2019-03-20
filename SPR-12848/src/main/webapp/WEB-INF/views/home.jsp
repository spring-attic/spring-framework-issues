<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Example form with hidden method PUT</h1>
  <form:form method="PUT" action="${pageContext.request.contextPath}/test">
    <p>Empty test form</p>
    <input type="submit" value="submit"/>
  </form:form>
</body>
</html>
