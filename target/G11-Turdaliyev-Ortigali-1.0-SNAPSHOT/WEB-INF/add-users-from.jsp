<%--
  Created by IntelliJ IDEA.
  User: Ortig'ali
  Date: 9/24/2022
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-Users-From</title>
</head>
<body>

<form action="/users" method="post">

    <label for="fullName" >Inami familyasi</label>
    <input name="fullName" type="text" id="fullName">
    <hr>
    <label for="password" >Password</label>
    <input name="password" type="text" id="password">
    <hr>
    <br>

    <button type="submit">Saqlash</button>
</body>
</html>
