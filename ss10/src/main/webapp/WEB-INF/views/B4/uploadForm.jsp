<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Avatar</title>
</head>
<body>
<h2>Upload Ảnh Đại Diện</h2>
<form:form modelAttribute="userProfile" action="upload-avatar" method="post" enctype="multipart/form-data">
    <p>Username:</p>
    <form:input path="username"/>
    <p>Chọn ảnh:</p>
    <form:input path="avatar" type="file"/>
    <br/><br/>
    <button type="submit">Upload</button>
</form:form>
</body>
</html>
