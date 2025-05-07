<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="demo.ss02.model.Product" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Price</th><th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <form action="updateProduct.jsp" method="get">
                    <input type="hidden" name="id" value="${product.id}" />
                    <input type="hidden" name="name" value="${product.name}" />
                    <input type="hidden" name="price" value="${product.price}" />
                    <input type="submit" value="Sửa" />
                </form>
                <form action="product" method="post" onsubmit="return confirmDelete()">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="id" value="${product.id}" />
                    <input type="submit" value="Xóa" />
                </form>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${not empty message}">
        <p style="color:green;">${message}</p>
    </c:if>

</table>

<script>
    function confirmDelete() {
        return confirm("Bạn có chắc muốn xóa sản phẩm này không?");
    }
</script>



<h3>Thêm sản phẩm mới</h3>
<form method="post" action="products">
    <label>ID:</label><br>
    <input type="number" name="id" required><br>
    <label>Tên sản phẩm:</label><br>
    <input type="text" name="name" required><br>
    <label>Giá:</label><br>
    <input type="number" name="price" step="0.01" required><br><br>
    <input type="submit" value="Thêm sản phẩm">
</form>

</body>
</html>
