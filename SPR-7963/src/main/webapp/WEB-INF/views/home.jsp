<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Home</h1>
  <hr>
  <p><a href="test?fq=foo">/test?fq=foo</a></p>
  <p><a href="test?fq=foo&fq=bar">/test?fq=foo&fq=bar</a></p>
  <p><a href="test?fq=foo,bar">/test?fq=foo,bar</a></p>
  <p><a href="test?fq=foo,bar&fq=bash">/test?fq=foo,bar&fq=bash</a></p>
  <p><a href="test?fq=foo,bar&fq=">/test?fq=foo,bar&fq=</a></p>
  
</body>
</html>
