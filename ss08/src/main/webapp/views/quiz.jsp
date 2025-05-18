<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Quiz Game</title></head>
<body>
<h2>Đoán hình ảnh</h2>

<img src="${currentQuestion.imageUrl}" alt="Câu hỏi" style="width:300px"/><br/><br/>

<c:if test="${not gameOver}">
    <form action="guess" method="post">
        Nhập câu trả lời: <input type="text" name="userAnswer"/>
        <button type="submit">Đoán</button>
    </form>
</c:if>

<p style="color:red;">${message}</p>

<c:if test="${gameOver}">
    <form action="quiz" method="get">
        <button type="submit">Chơi lại</button>
    </form>
</c:if>
</body>
</html>
