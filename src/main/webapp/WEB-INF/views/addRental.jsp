<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 08/08/2024
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Rental</title>
</head>
<body>
<h2>Add New Rental</h2>
<form action="${pageContext.request.contextPath}/addRental" method="post">
    Rental Code: <input type="text" name="rentalCode" required><br>
    Status:
    <select name="status">
        <option value="Empty">Trống</option>
        <option value="Util">Hạ tầng</option>
        <option value="Full">Đầy đủ</option>
    </select><br>
    Area (m²): <input type="number" name="area" min="20" required><br>
    Floor: <input type="number" name="floor" min="1" max="15" required><br>
    Rental Type:
    <select name="rentalType">
        <option value="Share office">Văn phòng chia sẻ</option>
        <option value="Full office">Văn phòng trọn gói</option>
    </select><br>
    Price (VNĐ): <input type="number" name="price" min="1000000" required><br>
    Start Date (dd/mm/yyyy): <input type="date" name="startDate" required><br>
    End Date (dd/mm/yyyy): <input type="date" name="endDate" required><br>
    <button type="submit">Add Rental</button>
</form>
</body>
</html>

