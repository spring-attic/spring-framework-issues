<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Home page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/wro/all.css"/>
        <script src="${pageContext.request.contextPath}/wro/all.js"></script>
        <script>
            function ajaxGetUser(){
                $.ajax({
                    type : "POST",
                    url : "${pageContext.request.contextPath}/admin/users",
                    dataType : "json",
                    data: {"<c:out value="${_csrf.parameterName}"/>":"<c:out value="${_csrf.token}"/>"},
                    cache: false,
                    error:function(jqXHR,  statusText){
                        alert("Exception prone when fetch users' data with "+statusText+":["+jqXHR.status+"]:\n\t"+jqXHR.statusText);
                    },
                    success:function(data){  
                        if(data.total==0){
                            $("#listuser").html("");
                        }else{
                            var html="<table border=\"1\"  class=\"ui-widget-content ui-corner-all\"><thead><tr><th><fmt:message key="account"/></th><th><fmt:message key="name"/></th><th><fmt:message key="birthday"/></th></tr></thead><tbody>";
                            for(var i=0;i<data.total;i++){
                                var user = data.users[i];
                                html = html + "<tr><td>"+user.account+"</td><td>"+user.name+"</td><td>"+user.birthday+"</td></tr>";
                            }
                            html += "</tbody></table>";
                            $("#listuser").hide().html(html).show("bounce",{},2000);
                        }
                    }
                });
            }
            $(function() {
                $("center") .show("puff");
            });
        </script>
    </head>
    <body>
        <table border="0" style="width:100%">
            <sec:authorize access="authenticated" var="logined">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/changePassword"><fmt:message key="changePassword"/></a></td>
                    <td align="right"><a href="${pageContext.request.contextPath}/j_spring_security_logout" >
                            <sec:authentication property="principal.username"/><fmt:message key="logout"/></a></td>
                </tr>
            </sec:authorize>
            <c:if test="${not logined}">
                <tr>
                    <td align="right"><a href="${pageContext.request.contextPath}/user/myinfo"><fmt:message key="myinfo"/></a></td>
                </tr>
            </c:if>
        </table>

    <center  style="display: none"><c:set var="world"><fmt:message key="world"/></c:set>
        <h1><fmt:message key="hello"/> ${empty member?world:member.name}</h1>
        <c:if test="${not empty member}">
            <table id="myinfo" border="1" class="ui-widget-content ui-corner-all">
                <tr><th colspan="2"><fmt:message key="myinfo"/></th></tr>
                <tr><td><fmt:message key="account"/>:</td><td>${member.id}</td></tr>
                <tr><td><fmt:message key="name"/>:</td><td>${member.name}</td></tr>
                <tr><td><fmt:message key="enabled"/>:</td><td><c:if test="${member.enabled}"><fmt:message key="true"/></c:if>
                        <c:if test="${not member.enabled}"><fmt:message key="false"/></c:if></td></tr>
                <tr><td><fmt:message key="birthday"/>:</td><td><fmt:formatDate value="${member.birthDay}" pattern="yyyy/MM/dd"/></td></tr>
                <tr><td><fmt:message key="role"/>:</td><td>
                        <c:forEach var="authority" items="${member.authorities}">
                            ${authority.authority}&nbsp;
                        </c:forEach>
                    </td></tr>
            </table>
        </c:if><br/>
        <c:set var="adminAjaxList"><fmt:message key="adminAjaxList"/></c:set>
        <input type="button" onclick="ajaxGetUser()" value="<c:out value="${adminAjaxList}" escapeXml="true"/>"/>
        <div id="listuser"></div>
    </center>
</body>
</html>
