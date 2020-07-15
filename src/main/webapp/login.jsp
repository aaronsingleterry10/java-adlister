<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/15/20
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% request.setAttribute("user", request.getParameter("username"));%>--%>
<%--<% request.setAttribute("pass", request.getParameter("password"));%>--%>
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
<h3>Please login:</h3>
<form action="login.jsp" method="post">
    <label for="username">username:</label>
    <input type="text" id="username" name="username">
    <label for="password">password:</label>
    <input type="password" id="password" name="password">
    <button>Submit</button>
</form>
<%--<c:choose>--%>
<%--    <c:when test="${param.username.equals('username')}">--%>
<%--        <%response.sendRedirect("/profile.jsp");%>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        <% response.sendRedirect("/login.jsp");%>--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>
</body>
</html>
