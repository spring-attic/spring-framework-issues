<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form modelAttribute="echoForm">
    <div><span>TEXT1 : </span><span id="text1">${fn:escapeXml(echoForm.text1).replaceAll('\\r\\n','<br>')}</span></div>
    <div><span>TEXT2 : </span><span id="text2">${fn:escapeXml(echoForm.text2).replaceAll('\\r\\n','<br>')}</span></div>
    <form:hidden path="text1"/>
    <form:hidden path="text2"/>
    <form:button id="redoButton" name="redo">Back</form:button>
    <form:button id="submitButton">Submit</form:button>
</form:form>

</body>
</html>
