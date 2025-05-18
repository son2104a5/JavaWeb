<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<h3>${message}</h3>

<c:if test="${not empty imageUrl}">
    <p><strong>Username:</strong> ${username}</p>
    <img src="${imageUrl}" alt="Avatar" width="200"/>
</c:if>

</body>
</html>
