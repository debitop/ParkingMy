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

<form method="post" action="/CarController">
    carid: <input name="carid" type="text" readonly value="${car.carId}"><br>
    carname:<input name="carname" type="text" value="${car.carname}"><br>
    ownerid:<input name="ownerid" type="text" readonly value="${ownerId}"><br>
    <input type="submit" value="OK">
</form>
</body>
</html>
