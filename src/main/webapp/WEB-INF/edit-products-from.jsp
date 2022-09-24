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
<form action="/products/edit" method="post">
    <input type="text" name="id"  hidden value="${products.id}">
    <label for="name" >Inami familyasi</label>
    <input value="${products.name}" name="name" type="text" id="name">
    <hr>
    <label for="price" >Price</label>
    <input  value="${products.price}" name="price" type="text" id="price">
    <hr>
    <br>

    <button type="submit">Saqlash</button>

</body>
</html>
