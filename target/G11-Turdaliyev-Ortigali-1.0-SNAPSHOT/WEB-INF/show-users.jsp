<%--
  Created by IntelliJ IDEA.
  User: Ortig'ali
  Date: 9/24/2022
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<a href="/users/get-form" >+ new users</a>

<c:forEach items="${users}" var="user" varStatus="loop">

    <h1> ${user.fullName}</h1>
    <p>${user.password}</p>
    <a href="/users/edit/${user.id}"> Edite</a>
    <a href="/users/delete/${user.id}"> Delete</a>
    <hr>
</c:forEach>
</body>
</html>
