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

<jsp:include page="header.jsp"/>

<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>
<div id="error_text"><fmt:message key="error_login"/></div>
</body>