<%--
  Created by IntelliJ IDEA.
  User: Moussa
  Date: 30/12/2015
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorites: testuser</title>
</head>
<body>

<table name="favorites">
    <c:forEach var="favorite" items="${favorites}">
    <tr>
        <td>${favorite}</td>
    </tr>
    </c:forEach>

</table>

<form action="addfavorite.do" method="post">
<input name="favorite"/>

<input name="Add favorite" type="submit" value="Add favorite">
</form>

</body>
</html>
