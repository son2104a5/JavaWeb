<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đặt Vé</title>
</head>
<body>
<h2>Form Đặt Vé</h2>

<form:form method="post" action="/book-ticket" modelAttribute="ticket">
    <p>Phim:</p>
    <form:input path="movieTitle"/>
    <p>Thời gian chiếu:</p>
    <form:input path="showTime" type="datetime-local"/>

    <p>Chọn ghế:</p>
    <form:checkboxes items="${ticket.seats}" path="seats" itemValue="seatNumber" itemLabel="seatNumber"/>

    <br/><br/>
    <input type="submit" value="Đặt Vé"/>
</form:form>
</body>
</html>
