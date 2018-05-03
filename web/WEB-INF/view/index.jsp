<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>ММДО Лаб1</title>
    <link href="/resources/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="/resources/images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="/resources/css/navigation/css/style.css">
</head>

<body>

<div align="center">
    <h2>Знаходження максимумів та мінімумів функції</h2>
    <!--/*@thymesVar id="greeting" type="com.md.mmdo_web.web.Greeting"*/-->
    <form action="/lab" method="post">
        <p><input type="text" name="i11" />x + <input type="text" name="i11" />y = <input type="text" name="i11" /> -> <select><option>max</option><option>min</option></select></p>
        <hr>
        <p><input type="text" name="i11" />x + <input type="text" name="i11" />y <select ><option value="1">>=</option><option value="0"><=</option></select> <input type="text" name="i11" /></p>
        <p><input type="text" name="i11" />x + <input type="text" name="i11" />y <select ><option value="1">>=</option><option value="0"><=</option></select> <input type="text" name="i11" /></p>
        <p><input type="text" name="i11" />x + <input type="text" name="i11" />y <select ><option value="1">>=</option><option value="0"><=</option></select> <input type="text" name="i11" /></p>
        <p><input type="submit" value="Отримати результат" class="inpIndex" /> <input type="reset" value="Очистити поля" class="inpIndex" /></p>
    </form>
</div>
<section class="about">
    <p class="about-links">
        <a href="http://www.cssflow.com/snippets/dark-navigation" target="_parent">View Article</a>
        <a href="http://www.cssflow.com/snippets/dark-navigation.zip" target="_parent">Download</a>
    </p>
    <p class="about-author">
        &copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> -
        <a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>
        Original PSD by <a href="http://www.premiumpixels.com/freebies/dark-navigation-menu-psd/" target="_blank">Orman Clark</a>
    </p>
</section>
</body>
</html>