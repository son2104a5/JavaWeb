<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.Product, model.CartManager" %>
<%
    HttpSession session = request.getSession();
    CartManager cart = (CartManager) session.getAttribute("cart");
    if (cart == null) {
        cart = new CartManager();
        session.setAttribute("cart", cart);
    }

    List<Product> products = cart.getCart();
%>

<!DOCTYPE html>
<html>
<head><title>Giỏ hàng</title></head>
<body>
<h2>Giỏ hàng của bạn</h2>

<% if (products.isEmpty()) { %>
<p>Chưa có sản phẩm nào trong giỏ.</p>
<% } else { %>
<table border="1" cellpadding="5">
    <tr>
        <th>Tên sản phẩm</th><th>Giá</th><th>Hành động</th>
    </tr>
    <% for (Product p : products) { %>
    <tr>
        <td><%= p.getProductName() %></td>
        <td><%= p.getPrice() %></td>
        <td>
            <form action="cart" method="get">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <input type="submit" value="Xóa">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<p><strong>Tổng cộng:</strong> <%= cart.getTotalPrice() %> VNĐ</p>
<% } %>

<br/>
<a href="product.jsp">🔙 Quay lại sản phẩm</a>
</body>
</html>
