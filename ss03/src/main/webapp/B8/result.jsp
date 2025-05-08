<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Book" %>
<%
  List<Book> result = (List<Book>) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head><title>Kết quả tìm kiếm</title></head>
<body>
<h2>Kết quả tìm kiếm:</h2>
<% if (result != null && !result.isEmpty()) { %>
<ul>
  <% for (Book b : result) { %>
  <li><%= b.getTitle() %> - <%= b.getAuthor() %> (<%= b.getYear() %>)</li>
  <% } %>
</ul>
<% } else { %>
<p>Không tìm thấy sách nào khớp.</p>
<% } %>
<a href="home.jsp">⬅ Quay lại</a>
</body>
</html>
