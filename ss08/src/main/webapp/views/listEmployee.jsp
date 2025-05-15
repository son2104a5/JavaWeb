<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Nhân Viên</title>
</head>
<body>
<h2>Danh Sách Nhân Viên</h2>

<c:if test="${not empty message}">
    <p style="color: green">${message}</p>
</c:if>

<table border="1">
    <tr>
        <th>Tên</th>
        <th>Email</th>
        <th>Vị Trí</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.position}</td>
        </tr>
    </c:forEach>
</table>

<a href="employees/add">Thêm nhân viên mới</a>
</body>
</html>
