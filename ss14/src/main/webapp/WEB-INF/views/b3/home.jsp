<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><spring:message code="title"/></title>
</head>
<body>
<h1><spring:message code="message"/></h1>

<form action="/change-language" method="post">
    <label>
        <select name="lang">
            <option value="vi">Tiếng Việt</option>
            <option value="en">English</option>
        </select>
    </label>
    <button type="submit">Change</button>
</form>
</body>
</html>
