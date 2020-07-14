<%--
  Created by IntelliJ IDEA.
  User: aaronsingleterry
  Date: 7/14/20
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String firstname = "Aaron"; %>
<%! String lastname = "Singleterry"; %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello, <%=firstname + " " + lastname%></h1>
    <%@include file="partials/aboutme.jsp"%>
    <h3>What would you like to do?</h3>
    <h3>View Profile</h3>

    <form action="/profile.jsp" method="get">
        <button>Go to profile</button>
    </form>

    <h3>Write a To Do list!</h3>
    <form action="/todo.jsp" method="post">
        <input type="text" id="item" name="item">
        <button>Add To List</button>
    </form>
</body>
</html>
