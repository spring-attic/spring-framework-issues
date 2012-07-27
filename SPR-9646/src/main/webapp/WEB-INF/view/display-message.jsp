<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Shows flash message</title></head>
<body>
<h2>Message:</h2>
<c:if test="${not empty flash_msg}">
    <strong><c:out value="${flash_msg}"/></strong>
</c:if>

<c:url value="/messages/new" var="new_url"/>
<form action="${new_url}" method="post">
    <input type="submit" value="number" />
</form>

<c:url value="/messages/new2" var="new_url2"/>
<form action="${new_url2}" method="post">
    <input type="submit" value="letter" />
</form>
</body>
</html>