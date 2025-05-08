<%@ page import="model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>

<%
  // Sản phẩm mẫu hard-code
  Product[] products = {
          new model.Product("1", "Sách Java", 150000),
          new model.Product("2", "Sách Web", 120000),
          new model.Product("3", "Sách SQL", 100000)
  };
%>

<% if (request.getAttribute("message") != null) { %>
<p style="color:green;"><%= request.getAttribute("message") %></p>
<% } %>

<% for (model.Product p : products) { %>
<form action="cart" method="post">
  <input type="hidden" name="id" value="<%= p.getId() %>">
  <input type="hidden" name="name" value="<%= p.getProductName() %>">
  <input type="hidden" name="price" value="<%= p.getPrice() %>">
  <p>
    <b><%= p.getProductName() %></b> - <%= p.getPrice() %> VNĐ
    <button type="submit">Thêm vào giỏ</button>
  </p>
</form>
<% } %>

<br/>
<a href="cart.jsp">🛒 Xem giỏ hàng</a>
</body>
</html>
