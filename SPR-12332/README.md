https://jira.spring.io/browse/SPR-12332

Going to http://localhost:8080/SPR-12332/test should cause the error

HTTP Status 500 - java.lang.IllegalStateException: Failed to determine lookup path: /SPR-12332/static/test.css

type Exception report

message java.lang.IllegalStateException: Failed to determine lookup path: /SPR-12332/static/test.css

description The server encountered an internal error that prevented it from fulfilling this request.

exception

org.apache.jasper.JasperException: java.lang.IllegalStateException: Failed to determine lookup path: /SPR-12332/static/test.css
	org.apache.jasper.servlet.JspServletWrapper.handleJspException(JspServletWrapper.java:549)
