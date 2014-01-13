<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Validation Test</title>
</head>
<body>
    <form:form commandName="address">
        <div>
            <form:errors path="*" cssClass="errorBox" />
        </div>
	    <table>
	          <tr>
	              <td>Zip:</td>
	              <td><form:input path="zip" /></td>
	          </tr>
	          <tr>
	              <td>Country:</td>
	              <td><form:input path="country" /></td>
	          </tr>
	          <tr>
	              <td colspan="2">
	                  <input type="submit" value="Save Changes" />
	              </td>
	          </tr>
	      </table>
    </form:form>
</body>
</html>
