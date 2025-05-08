<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách học sinh đăng ký vé xe</title></head>
<body>
<h2>Danh sách học sinh đã đăng ký</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Họ và tên</th>
        <th>Lớp</th>
        <th>Loại xe</th>
        <th>Biển số xe</th>
    </tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.fullName}</td>
            <td>${s.className}</td>
            <td>${s.vehicleType}</td>
            <td>${s.plateNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
