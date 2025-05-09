<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.*, model.Product" %>

<%
    request.setCharacterEncoding("UTF-8");

    // Danh sách sản phẩm tĩnh
    List<Product> productList = new ArrayList<>();
    productList.add(new Product(1, "Laptop", 1500, "Laptop hiệu năng cao"));
    productList.add(new Product(2, "Smartphone", 800, "Điện thoại chụp hình đẹp"));
    productList.add(new Product(3, "Tablet", 500, "Máy tính bảng tiện dụng"));

    // Lấy giá trị tìm kiếm
    String searchIdParam = request.getParameter("searchId");
    Product foundProduct = null;

    if (searchIdParam != null && !searchIdParam.isEmpty()) {
        try {
            int searchId = Integer.parseInt(searchIdParam);
            for (Product p : productList) {
                if (p.getId() == searchId) {
                    foundProduct = p;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            // ignore
        }
    }

    request.setAttribute("product", foundProduct);
%>

<!DOCTYPE html>
<html>
<head><title>Tìm kiếm sản phẩm</title></head>
<body>

<h2>Tìm kiếm sản phẩm theo ID</h2>

<form method="get" action="productSearch.jsp">
    Nhập ID sản phẩm: <input type="text" name="searchId" />
    <input type="submit" value="Tìm kiếm" />
</form>

<hr/>

<c:choose>
    <c:when test="${not empty param.searchId}">
        <c:choose>
            <c:when test="${not empty product}">
                <h3>Thông tin sản phẩm:</h3>
                <ul>
                    <li><strong>ID:</strong> ${product.id}</li>
                    <li><strong>Tên:</strong> ${product.name}</li>
                    <li><strong>Giá:</strong> ${product.price} VNĐ</li>
                    <li><strong>Mô tả:</strong> ${product.description}</li>
                </ul>
            </c:when>
            <c:otherwise>
                <p style="color:red;">Sản phẩm không tìm thấy.</p>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>

</body>
</html>
