<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kho Hạt Giống</title>
</head>
<body>
<h2>Kho Hạt Giống Của Bạn</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>Mã Hạt Giống</th>
        <th>Tên Hạt Giống</th>
        <th>Số Lượng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ws" items="${warehouseSeedsList}">
        <tr>
            <td>${ws.seeds.id}</td>
            <td>${ws.seeds.name}</td>
            <td>${ws.quantity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
