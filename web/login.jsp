<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="utils" uri="http://mycompany.com" %>

<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/login.css">
</head>
<body>

<fmt:setLocale value="${utils:getLocale(pageContext.request, pageContext.response)}"/>
<fmt:setBundle basename="strings"/>

<jsp:include page="header.jsp"/>

<form action="j_security_check" method="post" name="loginForm">
    <label><fmt:message key="login"/></label>
    <input name="j_username" size="20"/><br>
    <label><fmt:message key="password"/></label>
    <input type="password" name="j_password" size="20"/><br>
    <input type="submit" value="<fmt:message key="signin"/>"/>
</form>
</body>