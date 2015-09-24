<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>

<div><span>TEXT1 : </span><span id="text1">${fn:escapeXml(text1).replaceAll('\\r\\n','<br>')}</span></div>
<div><span>TEXT2 : </span><span id="text2">${fn:escapeXml(text2).replaceAll('\\r\\n','<br>')}</span></div>

<a href="<c:url value="/echo"/>">Go to Echo Form</a>

</body>
</html>
