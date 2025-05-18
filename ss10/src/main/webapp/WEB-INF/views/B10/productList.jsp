<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="/products/add">➕ Thêm sản phẩm</a>
<table border="1">
    <tr>
        <th>Tên</th><th>Giá</th><th>Tồn kho</th><th>Ảnh</th><th>Thao tác</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td><img src="${p.image}" width="100"/></td>
            <td>
                <a href="/products/edit/${p.id}">✏️</a>
                <a href="/products/delete/${p.id}" onclick="return confirm('Xóa?')">🗑️</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
