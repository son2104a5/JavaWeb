<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Giới thiệu bản thân</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 50px auto;
            background-color: white;
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1, h2 {
            color: #333;
        }
        p {
            line-height: 1.6;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Giới thiệu bản thân</h1>
    <%
        String name = "Nguyễn Văn A";
        String occupation = "Lập trình viên Full Stack";
        String description = "Tôi có kinh nghiệm trong phát triển web với Java, JSP, Spring Boot, và React. Đam mê công nghệ và thích giải quyết các vấn đề phức tạp.";
    %>
    <h2><%= name %></h2>
    <p><strong>Nghề nghiệp:</strong> <%= occupation %></p>
    <p><strong>Giới thiệu:</strong> <%= description %></p>
</div>
</body>
</html>
