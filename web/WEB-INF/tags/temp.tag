<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="headerTemplate" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" fragment="true" %>

<html>
<head>

    <title class="title"><jsp:invoke fragment="title"/></title>
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="/resources/images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="/resources/css/nav/css/style.css">

    <link href="/resources/js/angular.min.js">


</head>

<body>
<h3><jsp:invoke fragment="title"/></h3>
<headerTemplate:nav_temp/>

<jsp:doBody/>
<!-- Footer -->
<section class="about">
    <p class="about-links">
        <a href="index" target="_blank">Головна</a>
        <a href="lab3" target="_blank">Контакти</a>
        <a href="materials" target="_blank">Матеріали</a>
        <a href="lab1" target="_blank"> .</a>
        <br>

    </p>
    <p class="about-author">
        All rights reserved. &copy; 2018 Mykhajlo Drach
    </p>
</section>
</body>

</html>