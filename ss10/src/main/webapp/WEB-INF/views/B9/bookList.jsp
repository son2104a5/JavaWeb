<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Danh sách Sách</title></head>
<body>
<h2>Danh sách sách</h2>
<a href="/library/add">➕ Thêm mới</a>
<table border="1">
    <tr>
        <th>Tiêu đề</th>
        <th>Tác giả</th>
        <th>Mô tả</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.description}</td>
            <td>
                <a href="/library/edit/${book.id}">✏️ Sửa</a>
                <a href="/library/delete/${book.id}" onclick="return confirm('Xóa sách này?')">🗑️ Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
