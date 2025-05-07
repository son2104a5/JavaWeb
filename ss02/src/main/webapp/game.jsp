<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<head><title>Đoán Từ Bí Mật</title></head>
<body>
<h2>🔍 Game Đoán Từ</h2>

<p>Từ cần đoán:
  <strong>
    <% String displayWord = (String) request.getAttribute("displayWord"); %>
    <%= displayWord %>
  </strong>
</p>

<p>Số lần đoán sai còn lại: <%= request.getAttribute("remainingAttempts") %></p>

<c:if test="${not empty message}">
  <p style="color:red;"><%= request.getAttribute("message") %></p>
</c:if>

<c:if test="${not empty result}">
  <h3><%= request.getAttribute("result") %></h3>
  <form action="game" method="post">
    <input type="hidden" name="action" value="start" />
    <button type="submit">Chơi lại</button>
  </form>
</c:if>

<c:if test="${empty result}">
  <form action="game" method="post">
    <input type="hidden" name="action" value="guess" />
    <input type="text" name="guess" required />
    <button type="submit">Đoán</button>
  </form>
</c:if>
</body>
</html>
