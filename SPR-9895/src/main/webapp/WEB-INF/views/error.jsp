<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error page</title>
</head>
<body>
	<p>Error was raised</p>
	<hr>	
	<p>
		status:<%=request.getAttribute("javax.servlet.error.status_code") %>,
	   	reason:<%=request.getAttribute("javax.servlet.error.message") %>
	</p>
   
</body>
</html>