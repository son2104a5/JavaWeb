<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Thêm xe mới</h2>
<form:form modelAttribute="bus" method="post" action="/buses/add">
    <label>Biển số:</label>
    <form:input path="licensePlate" />
    <br>
    <form:errors path="licensePlate" cssClass="error" cssStyle="color: red;"/><br/>

    <label>Loại xe:</label>
    <form:select path="busType">
        <form:option value="NORMAL" label="NORMAL"/>
        <form:option value="VIP" label="VIP"/>
        <form:option value="LUXURY" label="LUXURY"/>
    </form:select><br/>

    <label>Số hàng:</label>
    <form:input path="rowSeat" type="number"/>
    <br>
    <form:errors path="rowSeat" cssClass="error" cssStyle="color: red;"/><br/>

    <label>Số cột:</label>
    <form:input path="colSeat" type="number"/>
    <br>
    <form:errors path="colSeat" cssClass="error" cssStyle="color: red;"/><br/>

    <label>URL Ảnh:</label>
    <form:input path="image" />
    <br>
    <form:errors path="image" cssClass="error" cssStyle="color: red;"/><br/>

    <button type="submit">Thêm xe</button>
</form:form>
