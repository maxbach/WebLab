<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
    <fmt:setBundle basename="strings"/>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/cart.css">
    <title><fmt:message key="cinema_name"/></title>
</head>

<body>

<jsp:include page="header.jsp"/>
<c:set var="lang" value="${utils:getLanguageCookie(pageContext.request, pageContext.response)}"/>

<c:forEach items="${sessionScope.cart.entrySet()}" var="pair">
    <c:set var="movie" value="${utils:getMovie(pair.getKey()).getMovieLanguage(lang)}"/>
    <div id="body">
        <img id="film_poster" onclick='openMoviePage(${pair.getKey()})' src='images/posters/${pair.getKey()}.jpg'/>

        <div id="right">
            <h2 id="film-title" onclick='openMoviePage(${pair.getKey()})'>${movie.name}</h2>
            <div class="choose_buttons" id="buy_buttons${pair.getKey()}">

                <div class="button minus" onclick="dec(${pair.getKey()})">-</div>
                <div class="button counter" id="number${pair.getKey()}">${pair.getValue()}</div>
                <div class="button plus" onclick="inc(${pair.getKey()})">+</div>

                <div class="button red_btn" onclick="deleteMovie(${pair.getKey()})"><fmt:message key="delete"/></div>

            </div>
            <div id="film-short"> ${movie.description} </div>
        </div>
    </div>
</c:forEach>

<div id="bottom">
    <hr/>
    <div id="footer">
        <div id="amount">
            <fmt:message key="sum"/>
            <div id="sum"></div>
        </div>
        <div class="button red_btn" id="cart_buy_btn" onclick="location.href ='order'">
            <fmt:message key="checkout"/>
        </div>
    </div>
</div>

<div id="numberOfTickets" style="display: none">${sessionScope.numberOfTickets}</div>
<div id="ticketPrice" style="display: none">${sessionScope.ticketPrice}</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/cart.js">

</script>
</body>
</html>