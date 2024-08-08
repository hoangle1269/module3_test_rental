<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Rentals</title>
</head>
<body>
<h2>List of Rentals</h2>

<!-- Search Form -->
<form action="${pageContext.request.contextPath}/searchRental" method="post">
    Rental Type:
    <select name="rentalType">
        <option value="">-- Select Type --</option>
        <option value="Văn phòng chia sẻ">Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói">Văn phòng trọn gói</option>
    </select>
    Price (VNĐ): <input type="number" name="price" min="0" step="100000"><br>
    Floor: <input type="number" name="floor" min="1" max="15"><br>
    <button type="submit">Search</button>
</form>

<!-- Rental List Table -->
<table border="1">
    <tr>
        <th>Rental Code</th>
        <th>Status</th>
        <th>Area (m²)</th>
        <th>Floor</th>
        <th>Rental Type</th>
        <th>Price (VNĐ)</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${rentals}" var="rental">
        <tr>
            <td>${rental.rentalCode}</td>
            <td>${rental.status}</td>
            <td>${rental.area}</td>
            <td>${rental.floor}</td>
            <td>${rental.rentalType}</td>
            <td>${rental.price}</td>
            <td>${rental.startDate}</td>
            <td>${rental.endDate}</td>
            <td>
                <form action="${pageContext.request.contextPath}/updateRental" method="get">
                    <input type="hidden" name="rentalCode" value="${rental.rentalCode}">
                    <button type="submit">Update</button>
                </form>
                <form action="${pageContext.request.contextPath}/deleteRental" method="post" onsubmit="return confirmDelete('${rental.rentalCode}')">
                    <input type="hidden" name="rentalCode" value="${rental.rentalCode}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<%--JS Confirm--%>
<script>
    function confirmDelete(rentalCode) {
        return confirm("Are you sure you want to delete rental with code " + rentalCode + "?");
    }
</script>
</body>
</html>
