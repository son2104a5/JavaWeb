<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Chi tiết xe: ${bus.licensePlate}</h2>
<p>Loại: ${bus.busType}</p>
<p>Số ghế: ${bus.totalSeat}</p>
<img src="${bus.image}" width="200"/>

<h3>Danh sách ghế</h3>
<table border="1">
    <c:forEach var="r" begin="1" end="${bus.rowSeat}">
        <tr>
            <c:forEach var="c" begin="1" end="${bus.colSeat}">
                <c:set var="seatCode" value="${fn:toUpperCase(fn:substring('ABCDEFGHIJKLMNOPQRSTUVWXYZ', r-1, r))}${c}"/>
                <c:forEach var="s" items="${seats}">
                    <c:if test="${s.nameSeat == seatCode}">
                        <td style="background-color: ${s.status == 'ĐÃ ĐẶT' ? '#f99' : '#9f9'}">${seatCode} (${s.price}đ)</td>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
