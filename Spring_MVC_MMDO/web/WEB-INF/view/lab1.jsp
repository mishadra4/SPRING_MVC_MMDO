<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<page:temp>

    <jsp:attribute name="title">Лабораторна робота №1</jsp:attribute>
    <jsp:body>
        <script>
            $("li.lab1").addClass("active");
            function exec () {
                var cols = document.getElementById("cols");
                var rows = document.getElementById("rows");
                document.getElementById("alg").innerHTML += "";
                for(var i = 0; i < cols.value; i++){
                    document.getElementById("alg").innerHTML += '<input class=\'data\' name="main"/>x';
                    document.getElementById("alg").innerHTML += i.toString();
                    document.getElementById("alg").innerHTML += "+";
                }
                document.getElementById("alg").innerHTML += ' -> <select name="mm"><option>max</option><option>min</option></select><br/>';
                for(var i = 0; i < rows.value; i++){
                    for(var j = 0; j < cols.value; j++) {
                        document.getElementById("alg").innerHTML += '<input class=\'data\' name="data"/>x';
                        document.getElementById("alg").innerHTML += j.toString();
                        document.getElementById("alg").innerHTML += "+";
                    }
                    document.getElementById("alg").innerHTML += "<select name='sign'><option value=\"1\"> >=</option><option value=\"0\"><=</option></select><input type=\"text\" name=\"data\" /><br/>";
                }
                document.getElementById("alg").innerHTML += "<p><input type=\"submit\" formmethod=\'post\' value=\"Отримати результат\" class=\"inpIndex\" /> <input type=\"reset\" value=\"Очистити поля\" class=\"inpIndex\" /></p>"
            }
        </script>
        <div align="center"  >
            <br/>
            <div>
                <h2>Знаходження максимумів та мінімумів функції</h2>
                <br/><br/>
                <form:form method="post" modelAttribute="size" action="/lab1" id="alg" >
                    Cols: <form:input path="cols"/> <br/>
                    Rows: <form:input path="rows"/> <br/>
                    <input type="button" value="Намалювати матрицю" onclick="exec()" />
                    <form:button>Next Page</form:button><br/><br/>
                </form:form>
            </div>
        </div>
    </jsp:body>

</page:temp>