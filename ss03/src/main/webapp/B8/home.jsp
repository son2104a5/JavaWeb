<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Book" %>
<%
    List<Book> books = (List<Book>) application.getAttribute("books");
%>
<!DOCTYPE html>
<html>
<head><title>Quản lý sách</title></head>
<body>
<h2>Thêm sách mới</h2>
<form action="book" method="post">
    Tên sách: <input type="text" name="title" required><br/>
    Tác giả: <input type="text" name="author" required><br/>
    Năm xuất bản: <input type="number" name="year" required><br/>
    <input type="submit" value="Thêm sách">
</form>

<hr>

<h2>Tìm kiếm sách</h2>
<form action="book" method="get">
    Tên sách: <input type="text" name="search">
    <input type="submit" value="Tìm">
</form>

<hr>

<h2>Danh sách sách đã thêm:</h2>
<% if (books != null && !books.isEmpty()) { %>
<ul>
    <% for (Book b : books) { %>
    <li><%= b.getTitle() %> - <%= b.getAuthor() %> (<%= b.getYear() %>)</li>
    <% } %>
</ul>
<% } else { %>
<p>Chưa có sách nào.</p>
<% } %>
</body>
</html>
