<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<page:temp>

    <jsp:attribute name="title">Лабораторна робота №4</jsp:attribute>
    <jsp:body>
        <script>
            $("li.lab4").addClass("active");
            function exec () {
                var cols = document.getElementById("cols");
                var rows = document.getElementById("rows");
                document.getElementById("alg").innerHTML += "<table> <tbody><tr>";
                for(var j = 0; j < cols.value; j++) {
                    document.getElementById("alg").innerHTML += "<th> Постачальник ";
                    document.getElementById("alg").innerHTML += j.toString();
                    document.getElementById("alg").innerHTML += "</th>";
                }
                document.getElementById("alg").innerHTML += "</tr>";
                for(var i = 0; i < cols.value; i++){
                    document.getElementById("alg").innerHTML += "<tr><td>Споживач ";
                    document.getElementById("alg").innerHTML += i.toString();
                    document.getElementById("alg").innerHTML += "</td>";
                    for(var j = 0; j < rows.value; j++) {
                        document.getElementById("alg").innerHTML += '<td><input class=\"lab\" name="data"/></td>';
                    }
                    document.getElementById("alg").innerHTML += "</tr>";
                }
                document.getElementById("alg").innerHTML += "<tbody></table><p><input type=\"submit\" formmethod=\'post\' value=\"Отримати результат\" class=\"inpIndex\" /> <input type=\"reset\" value=\"Очистити поля\" class=\"inpIndex\" /></p><br/>"
            }
        </script>
        <style>
            table {
                width: 100%; /* Ширина таблицы */
                background: white; /* Цвет фона таблицы */
                color: white; /* Цвет текста */
                border-spacing: 1px; /* Расстояние между ячейками */
            }
            td, th {
                padding: 5px; /* Поля вокруг текста */
                width: 40px;
            }
        </style>
        <div align="center"  >
            <br/>
            <div>
                <h2>Знаходження максимумів та мінімумів функції</h2>
                <br/><br/>
                <form:form method="post" modelAttribute="size" action="/lab4" id="alg" >
                    <div>
                        <tr>
                            <th>Споживачі: <form:input path="cols" /> </th>
                        </tr>
                        <tr>
                            <th>Постачальники: <form:input path="rows"/> </th>
                        </tr>
                    </div>
                    <input type="button" value="Намалювати матрицю" onclick="exec()" /><br/>
                </form:form>
            </div>
        </div>
    </jsp:body>

</page:temp>