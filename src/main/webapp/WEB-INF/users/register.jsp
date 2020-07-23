<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/23/20
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register" />
    </jsp:include>
</head>
<body>
    <h1>Would you like to register for a new account? Fill out the form below!</h1>

    <form action="/register" method="post">
        <label for="username">Create username: </label>
        <input type="text" name="username" id="username">
        <label for="email">Enter email: </label>
        <input type="text" name="email" id="email">
        <label for="password">Create password: </label>
        <input type="password" name="password" id="password">
        <button>Submit</button>
    </form>
</body>
</html>
