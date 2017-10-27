<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/header.css">
</head>
<body>

<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>
<div id="header">

    <div id="buttons">
        <div id="home" onclick="location.href='home'"><img src="images/header_home.png"></div>
        <div id="login"><img src="images/header_login.png"></div>
        <div id="cart"><img src="images/header_cart.png"></div>
    </div>

    <h1 id="title"><fmt:message key="cinema_name"/> </h1>

    <div id="languages"><h3 id="ru" onclick="openRu()">Rus</h3>
        <h3 id="en" onclick="openEn()">Eng</h3>
        <h3 id="fr" onclick="openFr()">Fra</h3>
    </div>

</div>
<script type="text/javascript" src="scripts/header.js"></script>
</body>
</html>
