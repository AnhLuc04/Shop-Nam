<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2020
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tiamo Shop</title>
</head>
<body>
<center>
    <h1>Tiamo Shop</h1>
    <h2>
        <a href="shop?action=update"></a>
    </h2>

</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                 Shop
                </h2>
            </caption>
            <c:if test="${shop != null}">
                <input type="hidden" name="id" value="<c:out value='${shop.setId()}' />"/>
            </c:if>
            <tr>
                <th>Url:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${shop.setUrl()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${shop.setName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${shop.setPrice()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="country" size="15"
                           value="<c:out value='${shop.setDescription()}' />"
                    />
                </td>
            </tr>


            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>