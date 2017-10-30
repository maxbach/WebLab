<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<c:set var="login" value="${utils:getUserName(pageContext.request)}"/>
<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/header.css">
</head>
<body>

<div id="header">

    <div id="open_buttons">
        <div class="header_button" onclick="location.href='home'"><img src="images/header_home.png"></div>
        <div class="header_button" onclick="location.href='cart'"><img src="images/header_cart.png"></div>
        <div class="header_button" id="header_signin" onclick="location.href='user-profile'"><img src="images/header_login.png"><div id="login">${login}</div></div>
        <div class="header_button" id="logout" style="display: none" onclick="logout()"><img src="images/header_exit.png"></div>
    </div>

    <h1 id="title"><fmt:message key="cinema_name"/> </h1>

    <div id="languages">
        <h3 class="header_language" onclick="openRu()">Rus</h3>
        <h3 class="header_language" onclick="openEn()">Eng</h3>
        <h3 class="header_language" onclick="openFr()">Fra</h3>
    </div>

</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/header.js"></script>
</body>
</html>
