<%--
  Created by IntelliJ IDEA.
  User: Moussa
  Date: 29/11/2015
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorites login</title>
</head>
<body>
<h1 id="error">${error}</h1>

<form action="login.do" method="post">
    <label>Username: </label>
    <input title="username" id="username" name="username" type="text"/>
    <br>
    <label>Password: </label>
    <input title="password" id="password" name="password" type="password"/>
    <br>
    <input title="login" id="login" name="login" type="submit">
</form>

</body>
</html>
