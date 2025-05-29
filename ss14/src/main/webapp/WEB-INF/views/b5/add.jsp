<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Order</title></head>
<body>
<h2>Add New Order</h2>
<form:form method="post" modelAttribute="order">
  Order Code: <form:input path="orderCode"/><br/>
  Product Name: <form:input path="productName"/><br/>
  Quantity: <form:input path="quantity" type="number"/><br/>
  <button type="submit">Add</button>
</form:form>
</body>
</html>
