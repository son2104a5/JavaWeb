<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Upload File to Cloud</title></head>
<body>
<h2>Upload File to Cloud</h2>
<form:form method="post" modelAttribute="uploadFile"
           enctype="multipart/form-data" action="upload-file">
    <p>Mô tả:</p>
    <form:input path="description"/>
    <p>Chọn file:</p>
    <form:input path="file" type="file"/>
    <br/><br/>
    <button type="submit">Upload</button>
</form:form>
</body>
</html>
