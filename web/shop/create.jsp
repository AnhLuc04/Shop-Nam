<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/06/2020
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop Tiamo</title>
</head>
<body>
<center>
    <h1>Tiamo Shop</h1>
    <h2>
        <a href="shop?action=create"></a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Shop</h2>
            </caption>
            <tr>
                <td></td>
                <td>
                    <button><a href="http://localhost:8080/shop?action=list">Hiển Thị</a></button>
                </td>
                <td>
                    <button><a href="http://localhost:8080/shop?action=search">Tìm Kiếm</a></button>
                </td>
                <td>
                    <button><a href="http://localhost:8080/shop?action=sort">Sắp Xếp</a></button>
                </td>
            </tr>
        </table>
        <table border="1" cellpadding="5">
            <tr>
                <th>url:</th>
                <td>
                    <input type="text" name="url" size="45">
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="Description" id="Description" size="15"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" href="http://localhost:8080/shop?action=list"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
