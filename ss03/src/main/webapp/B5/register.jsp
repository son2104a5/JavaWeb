<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký người dùng</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8"); // xử lý tiếng Việt
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name != null && email != null && password != null &&
                !name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
%>
<h2>Đăng ký thành công!</h2>
<p>Chào <strong><%= name %></strong>, bạn đã đăng ký với email: <strong><%= email %></strong></p>
<%
} else {
%>
<p style="color:red;">Vui lòng điền đầy đủ thông tin!</p>
<%
        }
    }
%>

<h2>Biểu mẫu đăng ký</h2>
<form method="post" action="register.jsp">
    Họ tên: <input type="text" name="name" required /><br/><br/>
    Email: <input type="email" name="email" required /><br/><br/>
    Mật khẩu: <input type="password" name="password" required /><br/><br/>
    <input type="submit" value="Đăng ký" />
</form>
</body>
</html>
