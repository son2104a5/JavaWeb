<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Thêm sản phẩm</title></head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form:form method="post" modelAttribute="product" action="${pageContext.request.contextPath}/products/add">
    Tên: <form:input path="name" /><br/><br/>
    Số lượng: <form:input path="quantity" type="number" /><br/><br/>
    Giá: <form:input path="price" type="number" step="0.01" /><br/><br/>
    <input type="submit" value="Thêm" />
</form:form>
</body>
</html>
