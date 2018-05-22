<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:temp>

    <jsp:attribute name="title">Materials</jsp:attribute>
    <jsp:body>
        <head>
            <link rel="stylesheet" href="/resources/css/button.css">
        </head>
        <script>
            $("li.materials").addClass("active");
        </script>
        <br/>
        <div class="down" align="center">
            <ul>
                <li><a href="/resources/downloads/lab4.rar" class="button black">Download</a><p class="down">Матеріали Лабораторна робота №2</p></li><br/><br/>
                <li><a href="/resources/downloads/lab4.rar" class="button black">Download</a><p class="down">Матеріали Лабораторна робота №3</p></li><br/><br/>
                <li><a href="/resources/downloads/lab4.rar" class="button black">Download</a><p class="down">Матеріали Лабораторна робота №4</p></li><br/><br/>
            </ul>
        </div>
        <br/>
        <br/>
    </jsp:body>

</page:temp>
