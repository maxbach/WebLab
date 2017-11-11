<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/error.css">
</head>
<body>

<ul>
<c:forEach items="${utils:getComments(pageContext.request)}" var="comment">
    <li>
        ${utils:getDateForUser(comment.date)}: ${comment.text}
    </li>
</c:forEach>
</ul>
<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>
</body>