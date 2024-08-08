<%--
  Created by IntelliJ IDEA.
  User: hoang
  Date: 08/08/2024
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
<h2>Error</h2>
<p>${errorMessage}</p>
<a href="${pageContext.request.contextPath}/listRentals">Back to List Rentals</a>
</body>
</html>

