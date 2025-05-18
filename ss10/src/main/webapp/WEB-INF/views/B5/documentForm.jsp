<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Upload Tài Liệu</title>
</head>
<body>
<h2>Upload Tài Liệu PDF</h2>

<form:form method="post" modelAttribute="document"
           enctype="multipart/form-data" action="upload-document">
    <p>Tiêu đề:</p>
    <form:input path="title"/>
    <p>Mô tả:</p>
    <form:textarea path="description"/>
    <p>Chọn file (PDF):</p>
    <form:input path="file" type="file"/>
    <br/><br/>
    <button type="submit">Tải lên</button>
</form:form>

</body>
</html>
