<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tạo Dự Án</title>
</head>
<body>
<h2>Tạo Dự Án Mới</h2>
<form:form method="post" action="/projects/create" modelAttribute="project" enctype="multipart/form-data">
    <p>Tên dự án:</p>
    <form:input path="name" />
    <p>Mô tả:</p>
    <form:textarea path="description" />
    <p>Tài liệu dự án:</p>
    <form:input path="documents" type="file" multiple="multiple" />
    <br/><br/>
    <input type="submit" value="Tạo Dự Án" />
</form:form>
</body>
</html>
