<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Thông tin đăng ký</title></head>
<body>
<h2>Đăng ký thành công!</h2>
<p><strong>Tên:</strong> ${user.name}</p>
<p><strong>Email:</strong> ${user.email}</p>
<p><strong>Số điện thoại:</strong> ${user.phone}</p>
<a href="${pageContext.request.contextPath}/register">Đăng ký người dùng mới</a>
</body>
</html>
