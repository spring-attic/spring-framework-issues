<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
</head>
<body>
<p>Hello</p>
<form:form modelAttribute="searchCriteria" method="post">
    my select multiple :
    <form:select path="codes">
        <form:options items="${availableCodes}"/>
    </form:select>
    <input type="submit"/>
</form:form>
</body>
</html>