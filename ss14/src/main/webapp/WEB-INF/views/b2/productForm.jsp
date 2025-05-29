<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Quản lý sản phẩm</title></head>
<body>
<h2>Thêm sản phẩm</h2>
<form:form method="post" modelAttribute="product">
    Mã SP: <form:input path="id"/><br/>
    Tên SP: <form:input path="name"/><br/>
    Giá: <form:input path="price"/><br/>
    <button type="submit">Thêm</button>
</form:form>

<h2>Danh sách sản phẩm</h2>
<c:forEach items="${productList}" var="p">
    ${p.id} - ${p.name} - ${p.price}
    <a href="/products/delete?id=${p.id}">Xóa</a><br/>
</c:forEach>
</body>
</html>
