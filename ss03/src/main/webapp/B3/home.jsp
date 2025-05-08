<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String redirect = request.getParameter("go");
    if ("true".equals(redirect)) {
%>
<jsp:forward page="welcome.jsp" />
<%
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
<h2>Trang chủ</h2>
<form action="home.jsp" method="get">
    <input type="hidden" name="go" value="true" />
    <input type="submit" value="Chuyển đến trang chào mừng" />
</form>
</body>
</html>
