<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 15.07.2018
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/DriverController">
    id: <input name="ownerId" type="text" readonly value="${driver.ownerId}"><br>
    name: <input name="username" type="text" value="${driver.username}"><br>
    <input type="submit" value="OK">

</form>

</body>
</html>
