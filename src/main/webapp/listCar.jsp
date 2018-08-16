<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 15.07.2018
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>id</th>
        <th>carName</th>
        <th>driverId</th>
        <th colspan="3">Actions</th>
    </tr>
    <c:forEach items="${cars}" var="temp">
        <tr>
            <td><c:out value="${temp.carId}"/></td>
            <td><c:out value="${temp.carname}"/></td>
            <td><c:out value="${temp.ownerId}"/></td>
            <td><a href="/CarController?action=edit&carId=${temp.carId}&ownerId=${temp.ownerId}">Edit</a></td>
            <td><a href="/CarController?action=delete&carId=${temp.carId}&ownerId=${temp.ownerId}">Delete</a></td>
            <td><a href="/ParkingRecordController?action=list&carId=${temp.carId}&ownerId=${temp.ownerId}">Records</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="/CarController?action=create&ownerId=${ownerId}">CreateCar</a>
<a href="/DriverController?action=list">Drivers</a>
</body>
</html>
