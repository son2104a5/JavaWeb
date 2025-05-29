<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Form</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form:form modelAttribute="user" method="post" action="/login">
    <p>Username: <form:input path="username"/></p>
    <p>Password: <form:password path="password"/></p>
    <button type="submit">Login</button>
</form:form>
</body>
</html>
