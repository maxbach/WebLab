<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/profile.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>
<c:set var="lang" value="${utils:getLanguageCookie(pageContext.request, pageContext.response)}"/>

<div id="time"></div>
<h2><fmt:message key="your_orders"/></h2>

<table>
    <tr>
        <th><fmt:message key="order_id"/></th>
        <th><fmt:message key="order_structure"/></th>
        <th><fmt:message key="order_date"/></th>
    </tr>
    <c:forEach items="${utils:getOrdersOfUser(pageContext.request)}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>
                <ul>
                    <c:forEach items="${order.details}" var="detail">
                        <li>
                                "${detail.movie.getMovieLanguage(lang).name}" x ${detail.quanity}
                        </li>
                    </c:forEach>
                </ul>
            </td>
            <td>${utils:getDateForUser(order.date)}</td>
        </tr>
    </c:forEach>
</table>

<h2><fmt:message key="your_comments"/></h2>

<div id="comments">

</div>

<p><fmt:message key="add_comment"/><br>
    <textarea id="input_comment" cols="40" rows="3"></textarea>
<div class="button grey_btn" id="add_comment_btn" onclick="addComment()" >
    <fmt:message key="add_comment"/>
</div>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/profile.js"></script>

</body>