<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thông Tin Người Dùng</title></head>
<body>
<h2>Đăng ký thành công!</h2>
<p><strong>Tên:</strong> ${user.name}</p>
<p><strong>Email:</strong> ${user.email}</p>
<p><strong>Số điện thoại:</strong> ${user.phone}</p>
<p><strong>Trạng thái:</strong> ${user.status ? "Hoạt động" : "Không hoạt động"}</p>
</body>
</html>
