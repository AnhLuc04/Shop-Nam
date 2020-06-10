<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/06/2020
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Shop Tiamo</h1>
    <h2>
        <a href="/shop?action=search"></a>
    </h2>
</center>

<fieldset>
    <legend>Search by country</legend>
    <form method="post">

            <button><a href="http://localhost:8080/shop?action=list">Hiển Thị</a></button>

            <button><a href="http://localhost:8080/shop?action=create">Thêm</a></button>

            <button><a href="http://localhost:8080/shop?action=sort">Sắp Xếp</a></button>

        <input type="text" name="country">
        <input type="submit" value="Search">
    </form>
</fieldset>
</body>
</html>
