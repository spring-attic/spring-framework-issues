<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>用戶OpenId識別</title>
    </head>
    <body>
        <c:if test="${not empty param.cause or not empty param.authfailed or not empty requestScope.errorMessage}">
            <c:set var="hasInfo" value="true"/>
            <div align="center" style="color:red;font-weight:bold;text-align: center" id="msgArea">
                <c:if test="${'expired' eq param.cause}">登錄已過時，請重新進行驗證</c:if>
                <c:if test="${'sessionExceed' eq param.cause}">同一帳號登錄數過多，請重新登錄。</c:if>
                <c:if test="${not empty param.authfailed}">異常 : ${SPRING_SECURITY_LAST_EXCEPTION.message}</c:if>
                <c:if test="${not empty requestScope.errorMessage}">${requestScope.errorMessage}</c:if>                                        
                </div>
        </c:if>
        <c:if test="${not empty hasInfo}">
            <form action="${cp}/j_spring_openid_security_check" method="post" style="text-align:center">
                <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
                <input type="hidden" name="openid_identifier" value="${applicationScope.directLoginUrl}"/>
                <input type="submit" value="繼續用戶驗證作業"/>
            </form>
        </c:if>
        <c:if test="${empty hasInfo}">
            <c:url value="/j_spring_openid_security_check" var="openIdCheckUrl">
                <c:param name="openid_identifier" value="${applicationScope.directLoginUrl}"/>
                <c:param name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </c:url>
            <c:redirect url="${openIdCheckUrl}"/>
        </c:if>
    </body>
</html>
