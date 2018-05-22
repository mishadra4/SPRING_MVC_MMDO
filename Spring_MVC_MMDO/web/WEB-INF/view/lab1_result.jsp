

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:temp>

    <jsp:attribute name="title">Lab 1</jsp:attribute>
    <jsp:body>
        <script>
            $("li.lab1").addClass("active");
        </script>
        <div align="center">
            <h2 class="res">Результат</h2>
            <p>Min = ${min}</p>
            <p>Max = ${max}</p>
            <a href="lab1" class="bordered-link">Ввести нові нерівності</a>
        </div>
    </jsp:body>

</page:temp>