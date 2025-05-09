<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.*, model.Revenue" %>

<%
    List<Revenue> revenueList = new ArrayList<>();
    revenueList.add(new Revenue("Tháng 1", 3000));
    revenueList.add(new Revenue("Tháng 2", 2500));
    revenueList.add(new Revenue("Tháng 3", 4500));
    revenueList.add(new Revenue("Tháng 4", 2000));

    request.setAttribute("revenues", revenueList);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Báo cáo doanh thu</title>
</head>
<body>

<h2>Báo cáo doanh thu theo tháng</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>

    <c:set var="total" value="0" />
    <c:forEach var="r" items="${revenues}">
        <tr>
            <td>${r.month}</td>
            <td>${r.amount} VNĐ</td>
        </tr>
        <c:set var="total" value="${total + r.amount}" />
    </c:forEach>
</table>

<br/>
<p><strong>Tổng doanh thu:</strong> ${total} VNĐ</p>

<c:choose>
    <c:when test="${total > 10000}">
        <p style="color:green;">Doanh thu vượt mức kỳ vọng!</p>
    </c:when>
    <c:otherwise>
        <p style="color:red;">Doanh thu chưa đạt mục tiêu.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
