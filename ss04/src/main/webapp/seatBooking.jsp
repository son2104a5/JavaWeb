<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.*, model.Seat" %>

<%
  request.setCharacterEncoding("UTF-8");

  List<Seat> seatList = new ArrayList<>();
  seatList.add(new Seat("A1", "Ghế A1", 50000, false));
  seatList.add(new Seat("A2", "Ghế A2", 50000, true));
  seatList.add(new Seat("A3", "Ghế A3", 50000, false));
  seatList.add(new Seat("B1", "Ghế B1", 60000, true));
  seatList.add(new Seat("B2", "Ghế B2", 60000, false));
  seatList.add(new Seat("B3", "Ghế B3", 60000, false));

  request.setAttribute("seats", seatList);
%>

<!DOCTYPE html>
<html>
<head>
  <title>Đặt ghế rạp phim</title>
</head>
<body>
<h2>Chọn ghế xem phim</h2>

<form method="post" action="seatBooking.jsp">
  <table border="1" cellpadding="10">
    <tr>
      <th>Mã ghế</th><th>Tên ghế</th><th>Giá</th><th>Trạng thái</th><th>Chọn</th>
    </tr>
    <c:forEach var="s" items="${seats}">
      <tr>
        <td>${s.code}</td>
        <td>${s.name}</td>
        <td>${s.price} VNĐ</td>
        <td>
          <c:if test="${s.booked}">Đã đặt</c:if>
          <c:if test="${!s.booked}">Trống</c:if>
        </td>
        <td>
          <c:if test="${!s.booked}">
            <input type="checkbox" name="selectedSeats" value="${s.price}" />
          </c:if>
          <c:if test="${s.booked}">
            <input type="checkbox" disabled />
          </c:if>
        </td>
      </tr>
    </c:forEach>
  </table>

  <br/>
  <input type="submit" value="Thanh toán" />
</form>

<%
  String[] selectedSeats = request.getParameterValues("selectedSeats");
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    if (selectedSeats != null && selectedSeats.length > 0) {
      int total = 0;
      for (String price : selectedSeats) {
        total += Integer.parseInt(price);
      }
%>
<h3>Tổng số tiền: <%= total %> VNĐ</h3>
<%
} else {
%>
<p style="color:red;">Vui lòng chọn ít nhất một ghế trước khi thanh toán.</p>
<%
    }
  }
%>

</body>
</html>
