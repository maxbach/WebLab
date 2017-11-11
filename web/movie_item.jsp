<%@ page import="utils.CookieUtils" %>
<%@ page import="utils.HibernateUtils" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<%
    String lang = (String) request.getAttribute("lang");
    String locale = CookieUtils.getLocale(request, response);
    session.setAttribute("movieLanguage", HibernateUtils.getMovie(Long.parseLong(request.getParameter("id")))
            .getMovieLanguage(lang));
%>
<fmt:setLocale value='<%=locale%>'/>
<fmt:setBundle basename="strings"/>

<link rel="stylesheet" type="text/css" href="styles/movie_item.css">
<c:set var="id" value='<%=request.getParameter("id")%>'/>

<jsp:useBean id="movieLanguage" class="Entities.MovieLanguage" scope="session">
    <jsp:setProperty name="movieLanguage" property="*"/>
</jsp:useBean>

<div id="body">
    <img id="film_poster" onclick='openMoviePage(${id})' src='images/posters/${id}.jpg'/>

    <div id="right">
        <h2 id="film-title" onclick='openMoviePage(${id})'>${movieLanguage.name}</h2>
        <div class="button red_btn" id="buy${id}" onclick="open_chooser(${id})"><fmt:message key="buy_title_btn"/></div>
        <div class="buy_buttons" id="buy_buttons${id}" style="display: none">
            <div class="button minus" onclick="dec(${id})">-</div>
            <div class="button counter" id="number${id}">1</div>
            <div class="button plus" onclick="inc(${id})">+</div>
            <div class="button red_btn" id="cart${id}" onclick=openCart(${id})><fmt:message
                    key="add_to_cart_btn"/></div>
            <div class="button grey_btn" onclick="close_chooser(${id})"><fmt:message key="cancel_btn"/></div>
        </div>
        <div id="film-short"> ${movieLanguage.description} </div>
    </div>
</div>
<script onload="close_chooser(${id})"></script>