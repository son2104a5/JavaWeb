<h3>Lịch chiếu phim</h3>
<table border="1">
    <tr>
        <th>Thời gian</th>
        <th>Phòng chiếu</th>
        <th>Số ghế trống</th>
        <th>Định dạng</th>
    </tr>
    <c:forEach var="schedule" items="${schedules}">
        <tr>
            <td><fmt:formatDate value="${schedule.showTime}" pattern="dd/MM/yyyy HH:mm" /></td>
            <td>
                <c:forEach var="room" items="${screenRooms}">
                    <c:if test="${room.id == schedule.screenRoomId}">
                        ${room.screenRoomName}
                    </c:if>
                </c:forEach>
            </td>
            <td>${schedule.availableSeats}</td>
            <td>${schedule.format}</td>
        </tr>
    </c:forEach>
</table>
