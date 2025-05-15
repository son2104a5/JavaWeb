<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Nhân Viên</title>
</head>
<body>
<h2>Thêm Nhân Viên Mới</h2>
<form:form action="/employees" method="post" modelAttribute="employee">
    Tên: <form:input path="name"/> <br/>
    Email: <form:input path="email"/> <br/>
    Vị trí: <form:input path="position"/> <br/>
    <button type="submit">Thêm</button>
</form:form>
</body>
</html>
