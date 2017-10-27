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

<body onload="changeSum()">
<jsp:include page="header.jsp"/>
<c:forEach items="${sessionScope.cart.entrySet()}" var="pair">
    <c:set var="lang" value="${utils:getLanguageCookie(pageContext.request, pageContext.response)}"/>
    <c:set var="movie" value="${utils:getMovie(pair.getKey()).getMovieLanguage(lang)}"/>
    <div id="body">
        <img id="film_poster" onclick='openMoviePage(${pair.getKey()})' src='images/posters/${pair.getKey()}.jpg'/>

        <div id="right">
            <h2 id="film-title" onclick='openMoviePage(${pair.getKey()})'>${movie.name}</h2>
            <div class="buttons" id="buy_buttons${pair.getKey()}">

                <div class="minus" onclick="dec(${pair.getKey()})">-</div>
                <div class="counter" id="number${pair.getKey()}">${pair.getValue()}</div>
                <div class="plus" onclick="inc(${pair.getKey()})">+</div>

            </div>
            <div id="film-short"> ${movie.description} </div>
        </div>
    </div>
</c:forEach>

<div id="sum_block">
    <fmt:message key="sum"/>
    <div id="sum"></div>
</div>
<script type="text/javascript" src="scripts/cart.js">
    function dec(id) {
        var inputId = 'number'.concat(id);
        var input = document.getElementById(inputId).innerHTML;
        var count = parseInt(input) - 1;
        count = count < 1 ? 1 : count;
        document.getElementById(inputId).innerHTML = count.toString();
        changeSum()
    }

    function inc(id) {
        var inputId = 'number'.concat(id);
        var input = document.getElementById(inputId).innerText;
        document.getElementById(inputId).innerHTML = (parseInt(input) + 1).toString();
        changeSum()
    }

    function changeSum() {
        document.getElementById("sum").innerHTML = "${utils:getCartSum(pageContext.session)}$"
    }

</script>
</body>
</html>