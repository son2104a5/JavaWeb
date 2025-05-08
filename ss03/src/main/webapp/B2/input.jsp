<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nhập thông tin người dùng</title>
</head>
<body>
<h2>Nhập thông tin người dùng</h2>
<form action="display.jsp" method="post">
    Tên: <input type="text" name="username" required /><br/><br/>
    Email: <input type="email" name="email" required /><br/><br/>
    <input type="submit" value="Lưu thông tin"/>
</form>
</body>
</html>
