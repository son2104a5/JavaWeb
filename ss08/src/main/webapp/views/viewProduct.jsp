<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Thông tin sản phẩm</title></head>
<body>
<h2>Thông tin sản phẩm mới thêm</h2>
<p>Tên: ${product.name}</p>
<p>Số lượng: ${product.quantity}</p>
<p>Giá: ${product.price}</p>
<a href="${pageContext.request.contextPath}/products">Quay lại danh sách</a>
</body>
</html>
