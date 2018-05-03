<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="headerTemplate" tagdir="/WEB-INF/tags" %>

<%@attribute name="title" fragment="true" %>

<html>
<head>

    <title ><jsp:invoke fragment="title"/></title>
    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="/resources/images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="/resources/css/navigation/css/style.css">

    <link href="/resources/js/angular.min.js">


</head>

<body>
<header>
    <div class="header-bg">
        <h1><jsp:invoke fragment="title"/></h1>
    </div>
</header>
<headerTemplate:nav_temp/>

<jsp:doBody/>
<!-- Footer -->
<section class="about">
    <p class="about-links">
        <a href="lab4" target="_blank">Lab 4</a>
        <a href="lab1" target="_blank">Lab1</a><br>
        <a href="lab3" target="_blank">Lab3-6</a>
        <a href="materials" target="_blank">Materials</a>
    </p>
    <p class="about-author">
        All rights reserved. &copy; 2018 Mykhajlo Drach
    </p>
</section>

</body>

</html>