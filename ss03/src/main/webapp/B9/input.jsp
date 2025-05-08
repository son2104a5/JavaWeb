<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Thêm người dùng</title></head>
<body>
<h2>Thêm người dùng mới</h2>
<form action="user" method="post">
    Tên: <input type="text" name="name" required><br/>
    Email: <input type="email" name="email" required><br/>
    <input type="submit" value="Thêm">
</form>

<% if (request.getAttribute("success") != null) { %>
<p style="color:green;">Người dùng đã được thêm thành công! <a href="listUser.jsp">Xem danh sách</a></p>
<% } %>
</body>
</html>
