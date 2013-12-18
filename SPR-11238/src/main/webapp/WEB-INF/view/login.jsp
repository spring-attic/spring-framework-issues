<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Login</title>
        <script type="text/javascript">
            window.onload=function(){
                document.getElementById("userid").focus();
            }
            function doSubmit(form){
                var comp = form.userid;
                if(!comp.value){
                    comp.focus();
                    alert("Please input your account.");
                    return false;
                }
                comp = form.password;;
                if(!comp.value){
                    comp.focus();
                    alert("Please input your password.");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body><center>
        <div align="center" style="color:red;font-weight:bold;text-align: center" id="msgArea">
            <c:if test="${not empty param.cause or not empty param.authfailed or not empty requestScope.errorMessage}">
                <c:if test="${'expired' eq param.cause}">Session expired,Please login again</c:if>
                <c:if test="${'sessionExceed' eq param.cause}">Session expired,Please try later.</c:if>
                <c:if test="${not empty param.authfailed}">error prone: ${SPRING_SECURITY_LAST_EXCEPTION.message}</c:if>
                <c:if test="${not empty requestScope.errorMessage}">${requestScope.errorMessage}</c:if>
            </c:if>                                        
        </div>
        <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" onsubmit="return doSubmt(this)">
            <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>" value="<c:out value="${_csrf.token}"/>"/>
            <table border="0" align="center" ><tbody>
                    <tr><td align="right"><label for="userid"><fmt:message key="account"/>:</label></td><td>
                            <input type="text" required aria-required="true" placeholder="Input your account" id="userid" name="j_username" value="${sessionScope.loginId}"/></td></tr>
                    <tr><td align="right"><label for="password"><fmt:message key="password"/>:</label></td><td>
                            <input type="password" required aria-required="true" placeholder="Input your password." id="password" name="j_password"/></td></tr>
                    <tr><td>&nbsp;</td><td noWrap><input id="rememberMe" name="_spring_security_remember_me" type="checkbox" value="true"/>
                            <label for="rememberMe">Remeber me in two weeks.</label></td>
                    <tr><td colSpan="2" align="center"><input type="submit"/><span style="width:300px">&nbsp;</span>
                            <input type="reset"/></td></tr>
                </tbody></table>
        </form>
        <table border="1" align="center">
            <tr><th><fmt:message key="account"/></th><th><fmt:message key="password"/></th></tr>
            <tr><td>admin</td><td>admin</td></tr>
            <tr><td>user1</td><td>user1</td></tr>
            <tr><td>user2</td><td>user2</td></tr>
        </table>
    </center></body>
</html>
