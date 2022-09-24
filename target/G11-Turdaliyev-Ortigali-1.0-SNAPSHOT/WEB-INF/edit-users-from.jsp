<%--
  Created by IntelliJ IDEA.
  User: Ortig'ali
  Date: 9/24/2022
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Users From</title>
</head>
<body>
<form action="/users/edit" method="post">
    <input type="text" name="id"  hidden value="${users.id}">
    <label for="fullName" >Inami familyasi</label>
    <input value="${users.fullName}" name="fullName" type="text" id="fullName">
    <hr>
    <label for="password" >Password</label>
    <input  value="${users.password}" name="password" type="text" id="password">
    <hr>
    <br>

    <button type="submit">Saqlash</button>

</body>
</html>
