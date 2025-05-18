<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kết Quả Upload</title>
</head>
<body>
<h3>${message}</h3>
<c:if test="${not empty docTitle}">
    <p><strong>Tiêu đề tài liệu:</strong> ${docTitle}</p>
</c:if>
</body>
</html>
