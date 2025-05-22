<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quản lý danh mục</title>
    <style>.error {color: red;}</style>
</head>
<body>
<h2>Thêm danh mục</h2>
<form:form modelAttribute="category" method="post"
           action="${category.id == 0 ? '/categories' : '/update-category'}">
    <p>Tên danh mục:</p>
    <form:input path="categoryName"/>
    <form:errors path="categoryName" cssClass="error"/><br/>

    <p>Trạng thái:</p>
    <form:checkbox path="status"/> Hoạt động

    <br/><br/>
    <button type="submit">Thêm mới</button>
</form:form>

<h2>Danh sách danh mục</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Tên</th><th>Trạng thái</th>
    </tr>
    <c:forEach items="${categories}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.categoryName}</td>
            <td>${c.status ? 'Hoạt động' : 'Không hoạt động'}</td>
            <td>
                <a href="/edit-category/${c.id}">Sửa</a> |
                <a href="/delete-category/${c.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
