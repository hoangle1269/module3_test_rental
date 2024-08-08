<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 08/08/2024
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Rental</title>
</head>
<body>
<h2>Update Rental Information</h2>
<form action="${pageContext.request.contextPath}/updateRental" method="post">
    Rental Code: <input type="text" name="rentalCode" value="${rental.rentalCode}" readonly><br>
    Status:
    <select name="status">
        <option value="Empty" <c:if test="${rental.status == 'Empty'}">selected</c:if>>Trống</option>
        <option value="Util" <c:if test="${rental.status == 'Util'}">selected</c:if>>Hạ tầng</option>
        <option value="Full" <c:if test="${rental.status == 'Full'}">selected</c:if>>Đầy đủ</option>
    </select><br>
    Area (m²): <input type="number" name="area" value="${rental.area}" min="20" required><br>
    Floor: <input type="number" name="floor" value="${rental.floor}" min="1" max="15" required><br>
    Rental Type:
    <select name="rentalType">
        <option value="Share office" <c:if test="${rental.rentalType == 'Share office'}">selected</c:if>>Văn phòng chia sẻ</option>
        <option value="Full office" <c:if test="${rental.rentalType == 'Full office'}">selected</c:if>>Văn phòng trọn gói</option>
    </select><br>
    Price (VNĐ): <input type="number" name="price" value="${rental.price}" min="1000000" required><br>
    Start Date (dd/mm/yyyy): <input type="text" name="startDate" value="${rental.startDate}" required><br>
    End Date (dd/mm/yyyy): <input type="text" name="endDate" value="${rental.endDate}" required><br>
    <button type="submit">Update Rental</button>
</form>
</body>
</html>

