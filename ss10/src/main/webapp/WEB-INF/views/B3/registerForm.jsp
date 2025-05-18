<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký tài khoản</title>
</head>
<body>
<h2>Form Đăng Ký</h2>
<form:form modelAttribute="account" method="post" action="register">
    <p>Username:</p>
    <form:input path="username"/>
    <p>Password:</p>
    <form:password path="password"/>
    <p>Email:</p>
    <form:input path="email"/>
    <br/><br/>
    <button type="submit">Đăng ký</button>
</form:form>
</body>
</html>
