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
    <thead>
    <tr>
        <th>Driver Id</th>
        <th>Name</th>
        <th colspan="3">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${drivers}" var="temp">
        <tr>
            <td><c:out value="${temp.ownerId}"/></td>
            <td><c:out value="${temp.username}"/></td>
            <td><a href="/DriverController?action=delete&ownerId=${temp.ownerId}">Delete</a> </td>
            <td><a href="/DriverController?action=edit&ownerId=${temp.ownerId}">Edit</a> </td>
            <td><a href="/CarController?action=list&ownerId=${temp.ownerId}">List Cars</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="/DriverController?action=create">Create Driver</a> </p>
</body>
</html>
