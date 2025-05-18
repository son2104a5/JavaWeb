<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thông tin vé</title></head>
<body>
<h2>Đặt Vé Thành Công!</h2>
<p><strong>Phim:</strong> ${ticket.movieTitle}</p>
<p><strong>Thời gian chiếu:</strong> ${ticket.showTime}</p>
<p><strong>Ghế:</strong>
    <c:forEach var="seat" items="${ticket.seats}">
        ${seat.seatNumber}
    </c:forEach>
</p>
<p><strong>Tổng tiền:</strong> ${ticket.totalAmount} VND</p>
</body>
</html>
