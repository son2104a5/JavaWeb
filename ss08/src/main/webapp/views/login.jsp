<%@ page contentType="text/html;charset=UTF-8" %>
<form action="login" method="post">
    Username: <input type="text" name="username" /><br/>
    Password: <input type="password" name="password" /><br/>
    <button type="submit">Đăng nhập</button>
    <p style="color:red;">${error}</p>
</form>
