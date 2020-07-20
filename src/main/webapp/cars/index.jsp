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
    <title>Cars</title>
</head>
<body>
    <h1>Welcome the Car Lot!</h1>

    <div class="container">
        <h3>Here are your cars:</h3>
        <c:forEach var="car" items="${cars}">
            <h3>Make:</h3>
            <p>${car.make}</p>
            <h3>Model:</h3>
            <p>${car.model}</p>
            <h3>Year:</h3>
            <p>${car.year}</p>
        </c:forEach>
    </div>


</body>
</html>
