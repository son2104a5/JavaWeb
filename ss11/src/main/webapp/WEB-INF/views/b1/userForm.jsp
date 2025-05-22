<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form Người Dùng</title>
</head>
<body>
<h2>Nhập Thông Tin Người Dùng</h2>
<form:form method="post" modelAttribute="user">
    <p>Tên: <form:input path="name"/> <br> <form:errors path="name" cssStyle="color: red"/></p>
    <p>Email: <form:input path="email"/> <br> <form:errors path="email" cssStyle="color: red"/></p>
    <p>Số điện thoại: <form:input path="phone"/> <br> <form:errors path="phone" cssStyle="color: red"/></p>
    <p>Mật khẩu: <form:password path="password"/> <br> <form:errors path="password" cssStyle="color: red"/></p>
    <p>Trạng thái: <form:checkbox path="status"/> (Hoạt động)</p>
    <br/>
    <button type="submit">Gửi</button>
</form:form>
</body>
</html>
