<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.*, model.Student" %>

<%
    // Danh sách sinh viên tĩnh
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "Nguyễn Văn A", 20, 8.2));
    students.add(new Student(2, "Trần Thị B", 21, 6.5));
    students.add(new Student(3, "Lê Văn C", 19, 7.5));
    students.add(new Student(4, "Phạm Thị D", 22, 9.0));
    students.add(new Student(5, "Hoàng Văn E", 18, 6.0));

    request.setAttribute("students", students);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>

<h2>Danh sách sinh viên</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Điểm trung bình</th>
    </tr>
    <c:set var="highScoreCount" value="0" />
    <c:forEach var="sv" items="${students}">
        <tr>
            <td>${sv.id}</td>
            <td>${sv.name}</td>
            <td>${sv.age}</td>
            <td>${sv.gpa}</td>
        </tr>
        <c:if test="${sv.gpa > 7.0}">
            <c:set var="highScoreCount" value="${highScoreCount + 1}" />
        </c:if>
    </c:forEach>
</table>

<br/>
<p><strong>Số sinh viên có điểm trung bình > 7.0:</strong> ${highScoreCount}</p>

</body>
</html>
