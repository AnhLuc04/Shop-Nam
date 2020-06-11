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
    <title>TiAMO SHOP</title>

</head>
<body>
<header class="header">
    <div class="signs">
        <ul>
            <a href="http://localhost:8080/shop?action=ShopTiamo">Cửa Hàng</a>
            <h1 class="h1">TIAMO SHOP</h1>
        </ul>
    </div>
    <div class="frames">
        <ul>
            <a href="/shop?action=sort">SALE OFF</a>
            <a href="/shop?action=create">Bạn có đồ muốn giao bán?</a>
            <a href="">086 2792153</a>
        </ul>
        <ul class="login">
            <form class="form-inline" action="/shop?action=search" method="post">
                <input class="form-control mr-sm-2" type="search"  name="name" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" value="search" type="submit">Search</button>
            </form>
            <button class="btn btn-primary" type="submit"><a href="http://localhost:8080/shop?action=User">Đăng Nhập</a></button>
            <button class="btn btn-primary" type="submit"><a href="http://localhost:8080/shop?action=createUser">Đăng Ký</a></button>
        </ul>
    </div>
</header>
<c:if test="${Shop!=null}">
    <input type="hidden" name="id" value="<c:out value='${shop.id}'/>">
</c:if>
<form class="form-inline" method="post">
    <input class="form-control mr-sm-2" type="text" placeholder="link ảnh" name="url" value="<c:out value="${shop.url}"/>">
    <input class="form-control mr-sm-2" type="text" placeholder="Name" name="name" value="<c:out value="${shop.name}"/>">
    <input class="form-control mr-sm-2" type="text" placeholder="Price" name="price" value="<c:out value="${shop.price}"/>">
    <input class="form-control mr-sm-2" type="text" placeholder="Miêu Tả" name="Description" value="<c:out value="${shop.Description}"/>">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="save">Kí Gửi</button>
</form>
<footer>
    <div class="card-heading text-center">
        <p>@Mọi người ủng hộ Shop Mk nha?@</p>
    </div>
</footer>
<link rel="stylesheet" href="../viewUpdate.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>