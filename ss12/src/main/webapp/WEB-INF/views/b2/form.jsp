<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
<h2>${product.id == 0 ? 'Add Product' : 'Edit Product'}</h2>
<form:form method="post" modelAttribute="product" action="${product.id == 0 ? '/products/add' : '/products/edit'}">
    <p>Name:</p>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>

    <p>Price:</p>
    <form:input path="price" type="number" step="0.01"/>
    <form:errors path="price" cssStyle="color: red"/>

    <p>Quantity:</p>
    <form:input path="quantity" type="number"/>
    <form:errors path="quantity" cssStyle="color: red"/>

    <p>Image URL:</p>
    <form:input path="image"/>
    <form:errors path="image" cssStyle="color: red"/>

    <br><br>
    <input type="submit" value="${product.id == 0 ? 'Add' : 'Update'}"/>
</form:form>
<a href="/products">Back to list</a>
</body>
</html>
