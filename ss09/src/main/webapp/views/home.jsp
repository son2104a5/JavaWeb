<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Phim đang chiếu</h2>
<c:forEach var="m" items="${movies}">
    <p>
        <a href="detailMovie?id=${m.id}">${m.title}</a> - ${m.director} - ${m.genre}
    </p>
</c:forEach>
</body>
</html>


