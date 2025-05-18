<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="views/welcome.jsp">Bài 1</a><br>
<a href="${pageContext.request.contextPath}/products">Bài 2</a><br>
<a href="products/add">Bài 3</a><br>
<a href="register">Bài 4</a><br>
<a href="users">Bài 5</a><br>
<a href="employees">Bài 6</a><br>
<a href="quiz">Bài 7</a><br>
<a href="home">Bài 8</a><br>
<a href="warehouse">Bài 9</a><br>
<a href="farm">Bài 10</a><br>
</body>
</html>