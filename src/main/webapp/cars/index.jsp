<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/20/20
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/partials/head.jsp"%>
    <title>Cars</title>
</head>
<body>
    <%@include file="/partials/navbarCars.jsp"%>
    <h1>Welcome the Car Lot!</h1>

    <div class="container">
        <h3>Here are your cars:</h3>
        <c:forEach var="car" items="${cars}">
            <div class="col-md-6">
                <h4>Make:</h4>
                <p>${car.make}</p>
                <h4>Model:</h4>
                <p>${car.model}</p>
                <h4>Year:</h4>
                <p>${car.year}</p>
            </div>
        </c:forEach>
    </div>
    <form action="/cars/create.jsp" method="GET">
        <button>Add Vehicle</button>
    </form>

</body>
</html>
