<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Product Form</title></head>
<body>
<h2>${product.id == 0 ? "Thêm Sản Phẩm" : "Chỉnh Sửa Sản Phẩm"}</h2>
<form:form method="post"
           modelAttribute="product"
           action="${product.id == 0 ? '/products/add' : '/products/edit'}"
           enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p>Tên sản phẩm:</p>
    <form:input path="name"/>
    <p>Giá:</p>
    <form:input path="price"/>
    <p>Tồn kho:</p>
    <form:input path="stock"/>
    <p>Ảnh:</p>
    <form:input path="imageFile" type="file"/>
    <br/><br/>
    <button type="submit">Lưu</button>
</form:form>
</body>
</html>
