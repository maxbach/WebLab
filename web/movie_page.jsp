<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>

<%
    String lang = (String) request.getAttribute("lang");
    ResourceBundle bundle = ResourceBundle.getBundle("strings",
            new Locale.Builder().setLanguage(lang).build());%>

<jsp:useBean id="movie" class="Entities.MovieLanguage" scope="request">
    <jsp:setProperty name="movie" property="*"/>
</jsp:useBean>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/page.css">
    <title><%=bundle.getString("cinema_name")%>
    </title>
</head>
<body onload='<%=request.getAttribute("initMethod").toString()%>'>

<jsp:include page="header.jsp"/>

<div id="body">
    <img id="film_poster" src='images/posters/<%=request.getParameter("id")%>.jpg'/>

    <div id="right">
        <h2 id="film-title">${movie.name}</h2>

        <div id="buttons">
            <div id="buy-btn" onclick="location.href='/cart';
                ${utils:addTicketsToCart(pageContext.session, requestScope.id, 1)}">
                <%=(String) bundle.getString("buy_title_btn")%>
            </div>
            <div id="film-short-title" onClick="showMain()"><%=(String) bundle.getString("main_info_btn")%>
            </div>
            <div id="film-long-title" onClick="showLong()"><%=(String) bundle.getString("long_info_btn")%>
            </div>
            <div id="film-review-title" onClick="showReview()"><%=(String) bundle.getString("review_btn")%>
            </div>
        </div>

        <div id="film-short" style='display:none;'> ${movie.description} </div>
        <div id="film-long" style='display:none;'> ${movie.moreInfo} </div>
        <div id="film-review" style='display:none;'> ${movie.reviews} </div>
    </div>
</div>

<script type="text/javascript" src="scripts/page.js"></script>
</body>
</html>
