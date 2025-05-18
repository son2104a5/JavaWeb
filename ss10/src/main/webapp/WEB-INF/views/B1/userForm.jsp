<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>Nhập thông tin cá nhân</h2>
<form:form modelAttribute="user" action="submit-form" method="post">
    <p>Tên:</p>
    <form:input path="name" />
    <p>Tuổi:</p>
    <form:input path="age" />
    <p>Địa chỉ:</p>
    <form:input path="address" />
    <br/><br/>
    <button type="submit">Gửi</button>
</form:form>
</body>
</html>
