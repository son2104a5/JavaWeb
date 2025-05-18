<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<h2>Shop Hạt Giống</h2>
<c:forEach var="s" items="${seeds}">
    <div>
        <img src="${s.imageUrl}" width="100"/>
        <p>${s.seedsName} - ${s.price} VND</p>
    </div>
</c:forEach>
