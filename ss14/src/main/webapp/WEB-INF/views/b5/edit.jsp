<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Order</title></head>
<body>
<h2>Edit Order</h2>
<form:form method="post" modelAttribute="order">
    Order Code: <form:input path="orderCode" readonly="true"/><br/>
    Product Name: <form:input path="productName"/><br/>
    Quantity: <form:input path="quantity" type="number"/><br/>
    <button type="submit">Update</button>
</form:form>
</body>
</html>
