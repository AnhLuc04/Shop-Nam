<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2020
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope['message'] != null}">
    <c:out value="${message}"></c:out>
</c:if>

<form action="/shop?action=User" method="post">

    <input type="text" name="username" id="username" placeholder="Username Here"/>
    <input type="password" id="password" name="password"/>

    <button type="submit">Login</button>
    <button type="submit"><a href="http://localhost:8080/shop?action=createUser">Đăng kí</a></button>

</form>

</body>
</html>
