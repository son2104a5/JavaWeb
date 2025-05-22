<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Đánh giá sản phẩm</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h2>Đánh giá sản phẩm</h2>

<form:form modelAttribute="productReview" method="post">
    <p>Tên:</p>
    <form:input path="name"/>
    <br/><form:errors path="name" cssClass="error"/>

    <p>Email:</p>
    <form:input path="email"/>
    <br/><form:errors path="email" cssClass="error"/>

    <p>Đánh giá (1-5):</p>
    <form:input path="rating" type="number"/>
    <br/><form:errors path="rating" cssClass="error"/>

    <p>Bình luận:</p>
    <form:textarea path="comment" rows="4" cols="30"/>
    <br/><form:errors path="comment" cssClass="error"/>

    <br/><br/>
    <button type="submit">Gửi đánh giá</button>
</form:form>

</body>
</html>
