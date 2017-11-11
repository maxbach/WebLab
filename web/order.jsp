<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/order.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>
<c:set var="lang" value="${utils:getLanguageCookie(pageContext.request, pageContext.response)}"/>

<h2><fmt:message key="list_of_tickets"/></h2>

<table>
    <tr>
        <th><fmt:message key="film_name"/></th>
        <th><fmt:message key="tickets_quanity"/></th>
    </tr>
    <c:forEach items="${sessionScope.cart.entrySet()}" var="pair">
        <tr>
            <c:set var="movie" value="${utils:getMovie(pair.getKey()).getMovieLanguage(lang)}"/>
            <td>${movie.name}</td>
            <td>${pair.getValue()}</td>
        </tr>
    </c:forEach>
</table>

<div class="switcher">
    <div class="button switch_button" id="order_pickup_switcher" onClick="showPickup()"><fmt:message
            key="pickup"/></div>
    <div class="button switch_button" id="order_delivery_switcher" onClick="showDelivery()"><fmt:message
            key="delivery"/></div>
</div>

<div id="pickup">
    <h3><fmt:message key="choose_cinema"/></h3>
    <select id="choose_cinema_list" onchange="changedList()">
        <option value="-1" disabled selected><fmt:message key="choose_cinema"/></option>
        <c:forEach items="${utils:getCinemas()}" var="cinema">
            <option value="${cinema.id}">${cinema.name}</option>
        </c:forEach>
    </select>
    <div id="map"></div>

    <c:forEach items="${utils:getCinemas()}" var="cinema">
        <div class="cinemaId" style="display: none">${cinema.id}</div>
        <div id="name${cinema.id}" style="display: none">${cinema.name}</div>
        <div id="x${cinema.id}" style="display: none">${cinema.coordinateX}</div>
        <div id="y${cinema.id}" style="display: none">${cinema.coordinateY}</div>
    </c:forEach>

</div>
<div id="delivery">
    <p><fmt:message key="input_address"/><br>
        <textarea id="input_address" onkeyup="checkButtonInDelivery()" cols="40" rows="3"></textarea></p>
</div>

<div id="bottom">
    <hr/>
    <div id="footer">
        <div id="amount">
            <fmt:message key="sum"/>
            <div id="sum"></div>
        </div>
        <div class="button red_btn" id="order_buy_btn" onclick="buyTickets()">
            <fmt:message key="buy"/>
        </div>
    </div>
</div>

<div id="numberOfTickets" style="display: none">${sessionScope.numberOfTickets}</div>
<div id="ticketPrice" style="display: none">${sessionScope.ticketPrice}</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://api-maps.yandex.ru/2.1/?lang=ru_RU"></script>
<script type="text/javascript" src="scripts/order.js"></script>

</body>
</html>