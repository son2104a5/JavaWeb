<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utils.OrderCalculator" %>
<%
    request.setCharacterEncoding("UTF-8");

    String[] products = request.getParameterValues("product");
    String[] quantitiesStr = request.getParameterValues("quantity");
    String[] pricesStr = request.getParameterValues("price");

    double total = 0;
    boolean submitted = "POST".equalsIgnoreCase(request.getMethod());

    if (submitted && products != null && quantitiesStr != null && pricesStr != null) {
        try {
            int len = products.length;
            double[] prices = new double[len];
            int[] quantities = new int[len];

            for (int i = 0; i < len; i++) {
                prices[i] = Double.parseDouble(pricesStr[i]);
                quantities[i] = Integer.parseInt(quantitiesStr[i]);
            }

            total = OrderCalculator.calculateTotal(prices, quantities);
        } catch (Exception e) {
            out.println("<p style='color:red;'>Lỗi định dạng số! Vui lòng nhập đúng.</p>");
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Đơn hàng</title>
</head>
<body>
<h2>Nhập thông tin đơn hàng</h2>
<form method="post">
    <table>
        <tr>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
        </tr>
        <% for (int i = 0; i < 3; i++) { %>
        <tr>
            <td><input type="text" name="product" required /></td>
            <td><input type="number" name="quantity" min="1" required /></td>
            <td><input type="number" name="price" step="0.01" min="0" required /></td>
        </tr>
        <% } %>
    </table>
    <br/>
    <input type="submit" value="Tính tổng" />
</form>

<% if (submitted) { %>
<h3>Tổng giá trị đơn hàng: <%= total %> VND</h3>
<% } %>
</body>
</html>
