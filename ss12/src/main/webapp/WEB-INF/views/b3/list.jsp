<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Danh sách xe khách</h2>
<a href="/buses/add">Thêm mới</a>
<table border="1">
    <tr>
        <th>ID</th><th>Biển số</th><th>Loại</th><th>Số ghế</th><th>Ảnh</th><th>Hành động</th>
    </tr>
    <c:forEach var="bus" items="${buses}">
        <tr>
            <td>${bus.id}</td>
            <td>${bus.licensePlate}</td>
            <td>${bus.busType}</td>
            <td>${bus.totalSeat}</td>
            <td><img src="${bus.image}" width="100"/></td>
            <td>
                <a href="/buses/${bus.id}">Chi tiết</a> |
                <a href="/buses/edit/${bus.id}">Sửa</a> |
                <a href="/buses/delete/${bus.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
