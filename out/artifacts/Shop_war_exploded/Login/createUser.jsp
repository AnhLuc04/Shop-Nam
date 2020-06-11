<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/06/2020
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tiamo Shop</h1>
<h2>
    <a href="shop?action=createUser"></a>
</h2>
<form method="post">
    <table>
        <tr>
            <th>User Name:</th>
            <td>
                <input type="text" name="username" id="username" size="45"/>
            </td>
        </tr>
        <tr>
            <th>password:</th>
            <td>
                <input type="text" name="password" id="password" size="45"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
