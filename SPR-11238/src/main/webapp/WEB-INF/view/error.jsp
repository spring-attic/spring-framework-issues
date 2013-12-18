<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Error Prone</title>
    </head>
    <%
        Exception ex = (Exception) request.getAttribute("exception");
        if (ex != null) {
            pageContext.setAttribute("exClassName", ex.getClass().getSimpleName());
        }
    %>
    <body><center>
                <c:if test="${'404' eq param.errorCode}">網頁不存在(Page not exists.)</c:if>
                <c:if test="${not empty param.accessDeined}">拒絕用戶存取:(Access denied:)</c:if>
                <c:if test="${not empty param.authfailed}">用戶權限異常:(Authority failed)</c:if>
                <c:if test="${not empty exClassName}">發生錯誤 (Error):${exClassName}</c:if>
                <c:if test="${'404' eq param.errorCode}">存取的網路資源不正確，請檢查網址是否正確。(Resources not found.)</c:if>
                <c:if test="${not empty param.accessDeined}">請查詢您的授權是否正確，或是洽詢權限管理人員調整您的權限。
                    (Access denied)
                    <sec:authorize access="authenticated"><div style="text-align:center;padding-top:30px;padding-right:30px">
                            <div><a href="${pageContext.request.contextPath}/j_spring_security_logout" >
                          <sec:authentication property="principal.username"/>登出(Logout)</a></div>
                    </sec:authorize>
                </c:if>
                <c:if test="${not empty param.authfailed}">${SPRING_SECURITY_LAST_EXCEPTION.message}</c:if>
                <c:if test="${not empty exClassName}">${requestScope.exception.message}</c:if>
    </center></body>
</html>