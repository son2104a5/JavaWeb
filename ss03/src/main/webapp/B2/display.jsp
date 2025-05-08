<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
    String email = request.getParameter("email");

    // Lưu thông tin vào ngữ cảnh (ServletContext)
    ServletContext context = getServletContext();
    context.setAttribute("username", username);
    context.setAttribute("email", email);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Thông tin người dùng</title>
</head>
<body>
<h2>Thông tin người dùng đã lưu:</h2>
<p><strong>Tên:</strong> <%= context.getAttribute("username") %></p>
<p><strong>Email:</strong> <%= context.getAttribute("email") %></p>
</body>
</html>
