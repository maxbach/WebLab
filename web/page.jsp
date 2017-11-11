<%@ page import="utils.CookieUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% String locale = CookieUtils.getLocale(request, response);%>

<fmt:setLocale value='<%=locale%>'/>
<fmt:setBundle basename="strings"/>

<html>

<jsp:useBean id="movie" class="Entities.MovieLanguage" scope="request">
    <jsp:setProperty name="movie" property="*"/>
</jsp:useBean>
<c:set var="id" value='<%=request.getParameter("id")%>'/>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/page.css">
    <title><fmt:message key="cinema_name"/>
    </title>
</head>
<body onload='<%=request.getAttribute("initMethod").toString()%>; close_chooser()'>

<jsp:include page="header.jsp"/>

<div id="body">
    <img id="film_poster" src='images/posters/<%=request.getParameter("id")%>.jpg'/>

    <div id="right">
        <h2 id="film-title">${movie.name}</h2>

        <div class="button red_btn" id="buy" onclick="open_chooser()"><fmt:message key="buy_title_btn"/></div>
        <div class="buy_buttons">
            <div class="button minus" onclick="dec()">-</div>
            <div class="button counter" id="number">1</div>
            <div class="button plus" onclick="inc()">+</div>
            <div class="button red_btn" onclick=openCart(${id})><fmt:message
                    key="add_to_cart_btn"/></div>
            <div class="button cancel" onclick="close_chooser()"><fmt:message key="cancel_btn"/></div>
        </div>

        <div class="switcher">
            <div class="button switch_button" id="film-short-title" style='margin-left: 0;' onClick="showMain()"><fmt:message key="main_info_btn"/></div>
            <div class="button switch_button" id="film-long-title" onClick="showLong()"><fmt:message key="long_info_btn"/></div>
            <div class="button switch_button" id="film-review-title" onClick="showReview()"><fmt:message key="review_btn"/></div>
        </div>

        <div id="film-short" style='display:none;'> ${movie.description} </div>
        <div id="film-long" style='display:none;'> ${movie.moreInfo} </div>
        <div id="film-review" style='display:none;'> ${movie.reviews} </div>
    </div>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/page.js"></script>
</body>
</html>
