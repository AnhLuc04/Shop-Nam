<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2020
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sort</title>
</head>
<body>
<center>
    <h1>Shop Tiamo</h1>
    <h2>
        <a href="/shop?action=sort"></a>
    </h2>
</center>

<div align="center">
    <table border="1">
        <td>
            <button><a href="http://localhost:8080/shop?action=list">Hiển Thị</a></button>
        </td>
        <td>
            <button><a href="http://localhost:8080/shop?action=create">Thêm</a></button>
        </td>
        <td>
            <button><a  href="http://localhost:8080/shop?action=search">Tìm Kiếm</a></button>
        </td>
        <tr>
            <th>ID</th>
            <th>url</th>
            <th>Name</th>
            <th>price</th>
            <th>Description</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${shop}" var="shop">
            <tr>
                <td><c:out value="${shop.getId()}"></c:out></td>
                <td><c:out value="${shop.getUrl()}"></c:out></td>
                <td><c:out value="${shop.getName()}"></c:out></td>
                <td><c:out value="${shop.getPrice()}"></c:out></td>
                <td><c:out value="${shop.getDescription()}"></c:out></td>
                <td><a href="/shop?action=edit&id=${get.id}">Edit</a></td>
                <td><a href="/shop?action=delete&id=${get.id}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
