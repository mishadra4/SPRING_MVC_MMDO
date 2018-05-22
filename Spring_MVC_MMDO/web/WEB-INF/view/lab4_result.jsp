

<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:temp>

    <jsp:attribute name="title">Лабораторна робота №4</jsp:attribute>
    <jsp:body>
        <script>
            $("li.lab4").addClass("active");
        </script>
        <div align="center">
            <h2 class="res">Результат</h2></br>

            <p>Цільова функція = ${result.functionValue}</p>
            <c:forEach var="int" items="${result.optPlan}">
                <tr>
                    <td><c:out value="int"/></td>
                </tr>
            </c:forEach>
            <a href="lab4" class="bordered-link">Ввести нові нерівності</a>
        </div>
    </jsp:body>

</page:temp>