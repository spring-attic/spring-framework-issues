<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<form:form modelAttribute="echoForm">
    TEXT1 : <form:textarea path="text1" rows="5"/>(Spring form:textarea)<br>
    TEXT2 : <textarea id="text2" name="text2" rows="5">
<c:out value="${echoForm.text2}"/></textarea>(HTML standard textarea)<br>
    <form:button id="confirmButton" name="confirm">Confirm</form:button>
</form:form>

</body>
</html>
