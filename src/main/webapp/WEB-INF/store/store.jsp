<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/21/20
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
    <title>Waldo Martinez</title>
</head>
<body>
    <%@include file="/WEB-INF/partials/navbar.jsp"%>
    <h1>Welcome To Waldo Martinez!</h1>
    <h3>Here are our groceries:</h3>
    <c:forEach var="item" items="${items}">
<%--        <div class="card">--%>
<%--            <h5 class="card-header">${item.name}</h5>--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">${item.priceInCents} cents</h5>--%>
<%--                <a href="#" class="btn btn-primary">Add To Cart</a>--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${item.name}</h5>
                <p class="card-text">${item.priceInCents} cents</p>
                <a href="#" class="btn btn-primary">Add To Cart</a>
            </div>
        </div>
    </c:forEach>
</body>
</html>
