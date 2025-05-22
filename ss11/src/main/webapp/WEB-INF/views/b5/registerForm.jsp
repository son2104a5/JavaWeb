<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký theo nhóm</title>
    <style>.error {color: red;}</style>
</head>
<body>
<h2>Đăng ký tài khoản</h2>
<form:form modelAttribute="account" method="post">
    <p>Tên:</p>
    <form:input path="name" />
    <form:errors path="name" cssClass="error" element="div"/>

    <p>Email:</p>
    <form:input path="email" />
    <form:errors path="email" cssClass="error" element="div"/>

    <p>Vai trò:</p>
    <form:select path="role">
        <form:option value="">-- Chọn vai trò --</form:option>
        <form:option value="user">Người dùng</form:option>
        <form:option value="admin">Admin</form:option>
    </form:select>
    <form:errors path="role" cssClass="error" element="div"/>

    <p>Mã xác minh Admin (nếu có):</p>
    <form:input path="adminCode" />
    <form:errors path="adminCode" cssClass="error" element="div"/>

    <br/><br/>
    <input type="submit" value="Đăng ký"/>
</form:form>
</body>
</html>
