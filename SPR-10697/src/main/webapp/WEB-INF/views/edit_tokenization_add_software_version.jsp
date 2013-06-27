<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>

<style>
    #mainBody th {background-color:transparent; color:black;}
</style>

<form:form action="saveSoftwareVersion.html" modelAttribute="softwareVendor">

    <form:hidden path="id" />

    <%--
    <c:forEach items="${isActiveValues}" var="activeValues">
            <div>${activeValues}</div>
    </c:forEach>
    --%>

    <div style="font-weight:bold;">Software Vendor Management</div>

    <br/>
    <div>${softwareVendor.name}</div>
    <form:hidden path="name"/>

    <br/>

    <table border="0" style="border:0px;">
        <tr>
            <th>Software Name</th>
            <th>Software Version</th>
            <th>Tokenization&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>Active</th>

            <c:if test="${showDeleteSoftwareVersionLinks == true}">
                <th>&nbsp;</th>
            </c:if>
        </tr>

        <c:forEach items="${softwareVendor.software}" var="softwareVO" varStatus="softwareVOStatus">
            <form:hidden path="software[${softwareVOStatus.index}].id" />

            <c:forEach items="${softwareVO.versions}" var="softwareVersionVO" varStatus="softwareVersionVOStatus">
                <form:hidden path="software[${softwareVOStatus.index}].versions[${softwareVersionVOStatus.index}].id" />
                <tr>
                    <td>${softwareVO.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><form:hidden path="software[${softwareVOStatus.index}].name"/>
                    <td>${softwareVersionVO.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><form:hidden path="software[${softwareVOStatus.index}].versions[${softwareVersionVOStatus.index}].name"/>


                    <td><form:checkbox disabled="${!tokenizationCheckboxesEditable}" path="software[${softwareVOStatus.index}].versions[${softwareVersionVOStatus.index}].participation" /></td>
                    <td><form:checkbox disabled="${!activeCheckboxesEditable}" path="software[${softwareVOStatus.index}].versions[${softwareVersionVOStatus.index}].active" /></td>

                    <c:if test="${showDeleteSoftwareVersionLinks == true}">
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteSoftwareVersion.html?softwareVersionId=${softwareVersionVO.id}" onClick="return confirm('Are you sure you want to delete the version number?')">Delete</a></td>
                    </c:if>

                    <%--
                    <td><form:input path="software[${softwareVOStatus.index}].versions[${softwareVersionVOStatus.index}].active"/></td>
                    --%>
                </tr>
            </c:forEach>
        </c:forEach>


        <tr>
            <td><form:input path="newSoftwareNameToAdd.name"/></td>
            <td><form:input path="newSoftwareNameToAdd.versions[0].name"/></td>
            <td><form:checkbox path="newSoftwareNameToAdd.versions[0].participation"/></td>
            <td><form:checkbox path="newSoftwareNameToAdd.versions[0].active"/></td>
        </tr>
    </table>	

    <br/>











    <div>
        <input value="Save" type="submit"/>
    </div>
    <br/>
</form:form>
