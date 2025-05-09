<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
    request.setCharacterEncoding("UTF-8");

    String submitted = request.getParameter("submit");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    boolean isValid = "admin".equals(username) && "123456".equals(password);
%>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập</title></head>
<body>

<h2>Form Đăng Nhập</h2>
<form method="post" action="login.jsp">
    Tên đăng nhập: <input type="text" name="username" required><br/><br/>
    Mật khẩu: <input type="password" name="password" required><br/><br/>
    <input type="submit" name="submit" value="Đăng nhập">
</form>

<c:if test="${param.submit != null}">
    <c:if test="<%= isValid %>">
        <p style="color:green;">Đăng nhập thành công. Chào mừng <strong><%= username %></strong>!</p>
    </c:if>
    <c:if test="<%= !isValid %>">
        <p style="color:red;">Sai tên đăng nhập hoặc mật khẩu. Vui lòng thử lại.</p>
    </c:if>
</c:if>

</body>
</html>
