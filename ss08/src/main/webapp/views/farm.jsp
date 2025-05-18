<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Farm</title>
</head>
<body>
<h2>Mảnh ruộng của bạn</h2>
<table border="1">
    <tr>
        <c:forEach var="plot" items="${landPlots}" varStatus="status">
        <td style="text-align:center; width: 100px; height: 100px;">
            <c:choose>
                <c:when test="${plot.empty}">
                    <form method="post" action="/game/plant">
                        <input type="hidden" name="plotId" value="${plot.plotId}" />
                        <select name="seedId">
                            <c:forEach var="ws" items="${warehouseSeeds}">
                                <option value="${ws.id}">
                                        ${ws.seeds.name} (${ws.quantity})
                                </option>
                            </c:forEach>
                        </select><br/>
                        <button type="submit">Gieo</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <img src="${plot.seed.seeds.image}" width="64" height="64"/><br/>
                    <span>${plot.seed.seeds.name}</span>
                </c:otherwise>
            </c:choose>
        </td>
        <c:if test="${status.index % 5 == 4}"></tr><tr></c:if>
    </c:forEach>
</tr>
</table>
</body>
</html>
