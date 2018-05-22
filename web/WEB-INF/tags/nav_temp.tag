<!DOCTYPE html>
<%@tag description="Template Site tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:url value="/lab1" var="lab1"/>
<c:url value="/lab1_result" var="lab1_result"/>
<c:url value="/lab3" var="lab3"/>
<c:url value="/lab4" var="lab4"/>
<c:url value="/lab3_result" var="lab3_result"/>
<c:url value="/lab4_result" var="lab4_result"/>
<c:url value="/materials" var="materials"/>
<c:url value="/" var="index"/>
<style>
    #main{
        border-radius: 10px;
    }
    .drop{
        border-radius: 6px;
        border-bottom: 6px;
    }
    a{
        color: #2e3131;
    }
    body{
        background-color: #d6d8db;
        color: #2e3131;
    }
    .about {
        margin-top: 100px;
        padding: 8px;
        width: 100%;
        font: 10px/18px 'Lucida Grande', Arial, sans-serif;
        color: #bbb;
        text-align: center;
        text-shadow: 0 -1px rgba(0, 0, 0, 0.3);
        background: #383838;
        background: rgba(34, 34, 34, 0.8);
        border-radius: 0px;
        background-image: -webkit-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
        background-image: -moz-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
        background-image: -o-linear-gradient(top, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
        background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.3));
        -webkit-box-shadow: inset 0 0 0 1px rgba(0, 0, 0, 0.2), 0 0 6px rgba(0, 0, 0, 0.4);
        box-shadow: inset 0 0 0 1px rgba(0, 0, 0, 0.2), 0 0 6px rgba(0, 0, 0, 0.4);
    }
    .about a {
        color: #eee;
        text-decoration: none;
        border-radius: 0px;
        -webkit-transition: background 0.1s;
        -moz-transition: background 0.1s;
        -o-transition: background 0.1s;
        transition: background 0.1s;
    }
    .about a:hover {
        text-decoration: none;
        background: #555;
        background: rgba(255, 255, 255, 0.15);
    }

    .about-links {
        height: 30px;
    }
    .about-links > a {
        float: left;
        width: 50%;
        line-height: 30px;
        font-size: 12px;
    }

    .about-author {
        text-align: center;
        margin-top: 5px;
        color: #7f7f7f;
    }
    .about-author > a {
        padding: 1px 3px;
        margin: 0 -1px;
    }
</style>
<nav>
    <ul id="main">
        <li><a href="index">Головна</a></li>
        <li><a href="#">Лабораторні роботи</a>
            <ul class="drop">
                <div>
                    <a href="lab1"><li>Лаб 1</li></a>
                    <a href="lab3"><li>Лаб 3</li></a>
                    <a href="lab4"><li>Лаб 4</li></a>
                    <a href="lab1"><li>Лаб 7</li></a>
                </div>
            </ul>
        </li>
        <li><a href="materials">Матеріали</a></li>
        <li><a href="#">Контакти</a></li>
        <div id="marker"></div>
    </ul>
</nav>
<!--<div id="dropdown-menu" class="dropdown-menu">
<li class="green"><a href="lab1.html">Лаб.№2</a></li>
<li class="lab3 orange"><a href="lab3">Лаб.№3-6</a></li>
<li class="lab4 red"><a href="lab4">Лаб.№4</a></li>
<li class="materials purple"><a href="materials">Матеріали</a></li>
    <span class="title">English</span>
    <ul>
        <li><a href="#">English</a></li>
        <li><a href="#">Русский</a></li>
        <li><a href="#">Украинский</a></li>
    </ul>
</div>-->


