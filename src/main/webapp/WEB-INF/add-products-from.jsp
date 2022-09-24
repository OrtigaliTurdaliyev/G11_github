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
    <title>Add-Products-From</title>
</head>
<body>

<form action="/products" method="post">

    <label for="name" >Nomni kiriting:</label>
    <input name="name" type="text" id="name">
    <hr>
    <label for="price" >Price</label>
    <input name="price" type="text" id="price">
    <hr>
    <br>

    <button type="submit">Saqlash</button>
</body>
</html>
