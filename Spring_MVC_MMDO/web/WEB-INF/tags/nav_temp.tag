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

        <nav>
            <div align="center">
                <ul>
                    <li class="lab1 yellow"><a href="lab1">Лаб.№1</a></li>
                    <li class="green"><a href="lab1.html">Лаб.№2</a></li>
                    <li class="lab3 orange"><a href="lab3">Лаб.№3-6</a></li>
                    <li class="lab4 red"><a href="lab4">Лаб.№4</a></li>
                    <li class="materials purple"><a href="materials">Матеріали</a></li>
                </ul>
            </div>
        </nav>