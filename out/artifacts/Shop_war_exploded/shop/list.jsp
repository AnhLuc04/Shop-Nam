<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/06/2020
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop Tiamo</title>
</head>
<body>
<center>
    <h1>Shop Tiamo</h1>
    <h2>
        <a href="/shop?action=list"></a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <td><button><a href="http://localhost:8080/shop?action=create">Thêm</a></button></td>
            <td><button><a>Tìm Kiếm</a></button></td>


        </tr>
    </table>
    <table border="1" cellpadding="5">
        <caption><h2></h2></caption>
        <tr>
            <th>ID</th>
            <th>url</th>
            <th>Name</th>
            <th>price</th>
            <th>Description</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach var="shop" items="${listShop}">
            <tr>
                <td><c:out value="${shop.getId()}"/></td>
                <td><c:out value="${shop.getUrl()}"/></td>
                <td><c:out value="${shop.getName()}"/></td>
                <td><c:out value="${shop.getPrice()}"/></td>
                <td><c:out value="${shop.getDescription()}"/></td>
                <td><a href="/shop?action=delete&id=${shop.id}">Xóa</a></td>
                <td><button><a href="http://localhost:8080/shop?action=update">Sửa</a></button></td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
