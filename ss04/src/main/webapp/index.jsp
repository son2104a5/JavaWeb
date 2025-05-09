<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Danh sách sinh viên" %></h1>--%>
<%--<br/>--%>
<%--<table border="1">--%>
<%--    <tr>--%>
<%--        <th>Tên</th>--%>
<%--        <th>Địa chỉ</th>--%>
<%--        <th>Học lực</th>--%>
<%--        <th>Chức năng</th>--%>
<%--    </tr>--%>
<%--    <c:forEach var="student" items="${students}">--%>
<%--        <tr>--%>
<%--            <td>${student.name}</td>--%>
<%--            <td>${student.address}</td>--%>
<%--            <td>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${student.score >= 8}">Giỏi</c:when>--%>
<%--                    <c:when test="${student.score >= 6}">Khá</c:when>--%>
<%--                    <c:when test="${student.score >= 5}">Trung bình</c:when>--%>
<%--                    <c:otherwise>Yếu</c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button>Sửa</button>--%>
<%--                <button>Xóa</button>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<%--<form method="POST" action="students">--%>
<%--    <h2>Thêm sinh viên:</h2>--%>
<%--    <label>Tên: </label>--%>
<%--    <input type="text" name="name" required/><br/>--%>
<%--    <label>Địa chỉ: </label>--%>
<%--    <input type="text" name="address" required/><br/>--%>
<%--    <label>Điểm: </label>--%>
<%--    <input type="number" name="score" min="0" max="10" step="0.1" required/><br/>--%>
<%--    <input type="submit" value="Thêm sinh viên"/>--%>
<%--</form>--%>
<a href="productList.jsp">Bài 1</a>
<a href="login.jsp">Bài 2</a>
<a href="main.jsp">Bài 3</a>
<a href="productInfo.jsp">Bài 4</a>
<a href="productSearch.jsp">Bài 5</a>
<a href="studentList.jsp">Bài 6</a>
<a href="productFilter.jsp">Bài 7</a>
<a href="revenueReport.jsp">Bài 8</a>
<a href="seatBooking.jsp">Bài 9</a>
</body>
</html>