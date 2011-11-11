<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>edit</title>
</head>
<body>
<c:url value="/registrations" var="url" />
<form:form action="${url}" method="post" modelAttribute="registration">
	<p><form:errors path="*"/></p>
	<p>ABNyN: <form:input path="abnYn" /></p>
	<p><button type="submit">Submit</button></p>
</form:form>
</body>
</html>
