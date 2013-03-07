<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
</head>
<body>
	<h1>parent.jsp before importing</h1>
	<p>\${variableA} = ${variableA}</p>
	<p>\${variableB} = ${variableB}</p>

	<c:import url="/child"/>

	<h1>parent.jsp after importing</h1>
	<p>\${variableA} = ${variableA}</p>
	<p>\${variableB} = ${variableB}</p>
</body>
</html>
