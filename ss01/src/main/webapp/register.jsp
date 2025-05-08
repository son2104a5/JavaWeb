<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Kết quả đăng ký vé xe</title></head>
<body>
<h2>${message}</h2>

<c:if test="${not empty fullName}">
    <table border="1" cellpadding="5">
        <tr><td>Họ và tên</td><td>${fullName}</td></tr>
        <tr><td>Lớp</td><td>${className}</td></tr>
        <tr><td>Loại xe</td><td>${vehicleType}</td></tr>
        <tr><td>Biển số xe</td><td>${plateNumber}</td></tr>
    </table>
</c:if>
</body>
</html>
