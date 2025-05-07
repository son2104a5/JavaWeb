<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Cập nhật sản phẩm</title></head>
<body>
<h2>Update Product</h2>

<form action="product" method="post">
    <input type="hidden" name="action" value="update" />
    <input type="hidden" name="id" value="${param.id}" />

    Name: <input type="text" name="name" value="${param.name}" /><br/>
    Price: <input type="text" name="price" value="${param.price}" /><br/>

    <input type="submit" value="Cập nhật" />
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
