<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng Ký</h2>
<form:form modelAttribute="user" method="post" action="/register">
    <p>Tên:</p>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error" cssStyle="color: red" element="div"/>

    <p>Email:</p>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error" cssStyle="color: red" element="div"/>

    <p>Mật khẩu:</p>
    <form:password path="password"/>
    <form:errors path="password" cssClass="error" cssStyle="color: red" element="div"/>

    <br/><br/>
    <button type="submit">Đăng ký</button>
</form:form>
</body>
</html>
