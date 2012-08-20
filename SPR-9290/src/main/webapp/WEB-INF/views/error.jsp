<%@ page contentType="application/json" pageEncoding="UTF-8"%>
{
   status:<%=request.getAttribute("javax.servlet.error.status_code") %>,
   reason:<%=request.getAttribute("javax.servlet.error.message") %>
}