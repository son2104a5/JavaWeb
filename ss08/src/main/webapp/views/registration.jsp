<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Đăng ký người dùng</title></head>
<body>
<h2>Form đăng ký</h2>

<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/register">

    <label>Tên người dùng:</label><br/>
    <form:input path="name" />
    <form:errors path="name" cssClass="error"/><br/><br/>

    <label>Email:</label><br/>
    <form:input path="email" />
    <form:errors path="email" cssClass="error"/><br/><br/>

    <label>Số điện thoại:</label><br/>
    <form:input path="phone" />
    <form:errors path="phone" cssClass="error"/><br/><br/>

    <input type="submit" value="Đăng ký" />
</form:form>

<style>
    .error { color: red; }
</style>
</body>
</html>
