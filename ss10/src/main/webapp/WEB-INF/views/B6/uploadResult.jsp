<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Kết Quả Upload</title></head>
<body>
<h3>${message}</h3>
<c:if test="${not empty fileUrl}">
    <p><strong>Mô tả:</strong> ${desc}</p>
    <p><strong>URL:</strong> <a href="${fileUrl}" target="_blank">${fileUrl}</a></p>
</c:if>
</body>
</html>
