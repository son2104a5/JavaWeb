<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Book Form</title></head>
<body>
<h2>${book.id == null ? "Thêm Sách" : "Chỉnh Sửa Sách"}</h2>
<form:form modelAttribute="book" method="post"
           action="${book.id == null ? '/library/add' : '/library/edit'}"
           enctype="multipart/form-data">
    <form:hidden path="id"/>
    <p>Tiêu đề:</p>
    <form:input path="title"/>
    <p>Tác giả:</p>
    <form:input path="author"/>
    <p>Mô tả:</p>
    <form:textarea path="description"/>
    <p>File E-Book (PDF):</p>
    <form:input path="file" type="file"/>
    <br/><br/>
    <button type="submit">Lưu</button>
</form:form>
</body>
</html>
