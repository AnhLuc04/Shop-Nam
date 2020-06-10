<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2020
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<center>
<h1>Edit User</h1>
</center>
<fieldset>
    <legend>Edit information</legend>

    <c:if test="${Shop!=null}">
        <input type="hidden" name="id" value="<c:out value='${Shop.id}'/>">
    </c:if>

    <form method="post">
        <table border="1">
            <tr>
                <th>url:</th>
                <td><input type="text" name="url" value="<c:out value="${Shop.url}"/>"></td>
            </tr>
            <tr>
                <th>User Name</th>
                <td><input type="text" name="name" value="<c:out value="${Shop.name}"/>"></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="text" name="price" value="<c:out value="${Shop.price}"/>"></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="text" name="Description" value="<c:out value="${Shop.Description}"/>"></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="Save" ></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>