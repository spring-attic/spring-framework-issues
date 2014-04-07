<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Error Occurred !</h1>

	<h2>
		<span>Class Name</span><span>:</span>
	</h2>
	<div>
		<span>${exceptionClassName}</span>
	</div>

	<h2>
		<span>Detail</span><span>:</span>
	</h2>
	<div>
		<span>${exception}</span>
	</div>

	<br>

	<spring:url value="/members/create" var="urlOfMemberCreate" />
	<a href="${urlOfMemberCreate}">Member Creation continued </a>

</body>
</html>
