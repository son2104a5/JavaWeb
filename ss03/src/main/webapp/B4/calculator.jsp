<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Máy tính cộng hai số</title>
</head>
<body>
<h2>Nhập hai số để tính tổng</h2>
<form action="calculator.jsp" method="get">
  Số thứ nhất: <input type="number" name="num1" required /><br/><br/>
  Số thứ hai: <input type="number" name="num2" required /><br/><br/>
  <input type="submit" value="Tính tổng" />
</form>

<%
  String n1 = request.getParameter("num1");
  String n2 = request.getParameter("num2");

  if (n1 != null && n2 != null) {
    try {
      int num1 = Integer.parseInt(n1);
      int num2 = Integer.parseInt(n2);
      int sum = num1 + num2;
%>
<h3>Kết quả: <%= num1 %> + <%= num2 %> = <%= sum %></h3>
<%
} catch (NumberFormatException e) {
%>
<p style="color:red;">Vui lòng nhập đúng định dạng số!</p>
<%
    }
  }
%>
</body>
</html>
