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
<a href="/products/get-form" >+ new products</a>

<c:forEach items="${products}" var="products" varStatus="loop">

    <h1> ${products.name}</h1>
    <p>${products.price}</p>
    <a href="/products/edit/${products.id}"> Edite</a>
    <a href="/products/delete/${products.id}"> Delete</a>
    <hr>
</c:forEach>
</body>
</html>
