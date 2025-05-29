<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Order List</title></head>
<body>
<h2>Order List</h2>
<a href="orders/add">Add New Order</a>
<table border="1">
    <tr>
        <th>Order Code</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.orderCode}</td>
            <td>${order.productName}</td>
            <td>${order.quantity}</td>
            <td>
                <a href="/orders/edit?code=${order.orderCode}">Edit</a> |
                <a href="/orders/delete?code=${order.orderCode}" onclick="return confirm('Delete this order?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
