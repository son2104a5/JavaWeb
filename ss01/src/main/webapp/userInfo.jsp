<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
    <style>
        table { border-collapse: collapse; width: 300px; margin-top: 20px; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; }
    </style>
</head>
<body>
<h2>User Information</h2>
<table>
    <tr>
        <th>Name</th>
        <td>${userName}</td>
    </tr>
    <tr>
        <th>Age</th>
        <td>${userAge}</td>
    </tr>
</table>
</body>
</html>
