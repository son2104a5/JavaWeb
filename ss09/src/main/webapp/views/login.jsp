<%--
  Created by IntelliJ IDEA.
  User: HONG NHUNG
  Date: 5/15/2025
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form th:action="@{/login}" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br>
    <label>Password:</label>
    <input type="password" name="password" required><br>
    <button type="submit">Đăng nhập</button>
</form>

<p th:if="${error}" th:text="${error}" style="color: red;"></p>
</body>
</html>

