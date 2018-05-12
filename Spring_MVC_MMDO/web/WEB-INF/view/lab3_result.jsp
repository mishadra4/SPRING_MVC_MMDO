
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:temp>

    <jsp:attribute name="title">Lab 3-6</jsp:attribute>
    <jsp:body>
        <script>
            $("li.lab3").addClass("active");
        </script>
        <h2>${user.cols}</h2>
        <h2>${user.rows}</h2>
    </jsp:body>

</page:temp>
