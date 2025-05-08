<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.User, model.UserManager" %>
<%
  UserManager manager = (UserManager) application.getAttribute("userManager");
  List<User> users = manager.getUsers();
%>
<!DOCTYPE html>
<html>
<head><title>Danh sách người dùng</title></head>
<body>
<h2>Danh sách người dùng</h2>
<a href="input.jsp">➕ Thêm người dùng mới</a><br/><br/>
<table border="1" cellpadding="5" cellspacing="0">
  <tr>
    <th>ID</th><th>Tên</th><th>Email</th><th>Hành động</th>
  </tr>
  <% for (User user : users) { %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td>
      <form action="user" method="get" onsubmit="return confirm('Bạn có chắc muốn xóa người dùng này?');">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        <input type="submit" value="Xóa">
      </form>
    </td>
  </tr>
  <% } %>
</table>
</body>
</html>
