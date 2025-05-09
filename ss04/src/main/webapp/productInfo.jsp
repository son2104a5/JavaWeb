<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="model.Product" %>
<%
    Product product = new Product(1, "Laptop", 1500);

    request.setAttribute("product", product);
%>

<!DOCTYPE html>
<html>
<head><title>Thông tin sản phẩm</title></head>
<body>

<h2>Thông tin sản phẩm</h2>

<c:choose>
    <c:when test="${not empty product}">
        <ul>
            <li><strong>ID:</strong> ${product.id}</li>
            <li><strong>Tên:</strong> ${product.name}</li>
            <li><strong>Giá:</strong> ${product.price} VNĐ</li>
        </ul>
    </c:when>
    <c:otherwise>
        <p style="color:red;">Sản phẩm không có thông tin.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
