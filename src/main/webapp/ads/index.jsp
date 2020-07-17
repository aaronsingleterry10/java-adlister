<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/17/20
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/partials/head.jsp"%>
    <title>Ads</title>
</head>
<body>
    <%@include file="/partials/navbar.jsp"%>
    <h1>Your Ads!</h1>
    
    <c:forEach var="ad" items="${ads}">
        <div>${ad.title}</div>
        <div>${ad.description}</div>
    </c:forEach>
</body>
</html>
