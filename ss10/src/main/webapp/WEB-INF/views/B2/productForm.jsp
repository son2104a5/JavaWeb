<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Nhập thông tin sản phẩm</h2>
<form:form modelAttribute="product" action="add-product" method="post">
    <p>Tên sản phẩm:</p>
    <form:input path="name" />
    <p>Giá:</p>
    <form:input path="price" />
    <p>Mô tả:</p>
    <form:textarea path="description" />
    <br/><br/>
    <button type="submit">Thêm sản phẩm</button>
</form:form>
</body>
</html>
