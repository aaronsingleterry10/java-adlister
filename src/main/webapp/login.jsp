<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/15/20
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        if (request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Welcome to the Site!</h1>
<%@include file="partials/header.jsp"%>
<h3>Please login:</h3>
<form action="login.jsp" method="post">
    <label for="username">username:</label>
    <input type="text" id="username" name="username">
    <label for="password">password:</label>
    <input type="password" id="password" name="password">
    <button>Submit</button>
</form>
<%@include file="partials/footer.jsp"%>
</body>
</html>
