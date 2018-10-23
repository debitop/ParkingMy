<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 17.07.2018
  Time: 19:06
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
        <th>recordId</th>
        <th>carModelId</th>
        <th>dateIn</th>
        <th>dateOut</th>
        <th>price</th>
        <th colspan="2">Actions</th>
    </tr>
<c:forEach items="${records}" var="temp">
    <tr>
        <td><c:out value="${temp.recordId}"/></td>
        <td><c:out value="${temp.carModelId}"/></td>
        <td><c:out value="${temp.dateIn}"/></td>
        <td><c:out value="${temp.dateOut}"/></td>
        <td><c:out value="${temp.price}"/></td>
        <td><a href="/ParkingRecordController?action=edit&recordId=${temp.recordId}&carId=${temp.carId}">Edit</a> </td>
        <td><a href="/ParkingRecordController?action=delete&recordId=${temp.recordId}&carId=${temp.carId}">Delete</a> </td>
    </tr>
    </c:forEach>
</table>
<a href="/ParkingRecordController?action=create&carId=${carID}">Create Record</a>
<a href="/CarController?action=list">Cars</a>
</body>
</html>
