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
	<h1>Member Creation Form</h1>

	<form:form modelAttribute="member">
		<div>
			<span>Name</span><span>:</span><span><form:input path="name" />
				<form:errors path="name" cssStyle="color : red;"/></span><br>
		</div>
		<div>
			<span>Email</span><span>:</span><span><form:input path="email" />
				<form:errors path="email" cssStyle="color : red;"/></span>
		</div>
		<div>
			<form:button>Create</form:button>
		</div>
	</form:form>

</body>
</html>
