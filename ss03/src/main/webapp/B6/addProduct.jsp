<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Product" %>
<%
    request.setCharacterEncoding("UTF-8");

    List<Product> productList = (List<Product>) application.getAttribute("productList");
    if (productList == null) {
        productList = new ArrayList<>();
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String desc = request.getParameter("description");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String status = request.getParameter("status");

        Product product = new Product(id, name, price, desc, stock, status);
        productList.add(product);

        application.setAttribute("productList", productList);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm mới</h2>
<form method="post">
    Mã sản phẩm: <input type="text" name="id" required /><br/><br/>
    Tên sản phẩm: <input type="text" name="name" required /><br/><br/>
    Giá: <input type="number" name="price" step="0.01" required /><br/><br/>
    Mô tả: <input type="text" name="description" required /><br/><br/>
    Số lượng: <input type="number" name="stock" required /><br/><br/>
    Trạng thái: <input type="text" name="status" required /><br/><br/>
    <input type="submit" value="Thêm sản phẩm" />
</form>

<br/><hr/><br/>

<h2>Danh sách sản phẩm đã thêm:</h2>
<%
    if (productList != null && !productList.isEmpty()) {
%>
<table border="1" cellpadding="8">
    <tr>
        <th>ID</th><th>Tên</th><th>Giá</th><th>Mô tả</th><th>Số lượng</th><th>Trạng thái</th>
    </tr>
    <%
        for (Product p : productList) {
    %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getProductName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getDescription() %></td>
        <td><%= p.getStock() %></td>
        <td><%= p.getStatus() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <p>Chưa có sản phẩm nào.</p>
    <%
        }
    %>
</table>
</body>
</html>
