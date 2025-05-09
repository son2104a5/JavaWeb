<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.*, model.Product" %>

<%
    request.setCharacterEncoding("UTF-8");

    List<Product> productList = new ArrayList<>();
    productList.add(new Product(1, "Laptop", 1500));
    productList.add(new Product(2, "Điện thoại", 800));
    productList.add(new Product(3, "Máy tính bảng", 600));
    productList.add(new Product(4, "Tai nghe", 200));
    productList.add(new Product(5, "Chuột máy tính", 100));

    request.setAttribute("products", productList);

    String minStr = request.getParameter("minPrice");
    String maxStr = request.getParameter("maxPrice");

    double minPrice = 0;
    double maxPrice = Double.MAX_VALUE;
    boolean filterApplied = false;

    if (minStr != null && maxStr != null && !minStr.isEmpty() && !maxStr.isEmpty()) {
        try {
            minPrice = Double.parseDouble(minStr);
            maxPrice = Double.parseDouble(maxStr);
            filterApplied = true;
        } catch (NumberFormatException e) {
            // bỏ qua nếu sai định dạng
        }
    }

    request.setAttribute("minPrice", minPrice);
    request.setAttribute("maxPrice", maxPrice);
    request.setAttribute("filterApplied", filterApplied);
%>

<!DOCTYPE html>
<html>
<head><title>Lọc sản phẩm theo giá</title></head>
<body>

<h2>Lọc sản phẩm theo khoảng giá</h2>

<form method="get" action="productFilter.jsp">
    Giá tối thiểu: <input type="text" name="minPrice" value="${param.minPrice}" />
    Giá tối đa: <input type="text" name="maxPrice" value="${param.maxPrice}" />
    <input type="submit" value="Lọc" />
</form>

<hr/>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Tên sản phẩm</th><th>Giá</th>
    </tr>
    <c:set var="found" value="false" />
    <c:forEach var="p" items="${products}">
        <c:if test="${filterApplied and p.price >= minPrice and p.price <= maxPrice}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price} VNĐ</td>
            </tr>
            <c:set var="found" value="true" />
        </c:if>
    </c:forEach>
</table>

<c:if test="${filterApplied and not found}">
    <p style="color:red;">Không có sản phẩm nào trong khoảng giá này.</p>
</c:if>

</body>
</html>
