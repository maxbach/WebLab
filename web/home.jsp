<%@ page import="utils.HibernateUtils" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="Entities.Genre" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    String lang = (String) request.getAttribute("lang");
    String genreId = (String) request.getAttribute("genre");
    ResourceBundle bundle = ResourceBundle.getBundle("strings",
            new Locale.Builder().setLanguage(lang).build());%>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <title><%=bundle.getString("cinema_name")%>
    </title>
</head>

<body>
<jsp:include page="header.jsp"/>
<div id="filter">
    <div id="genre_select">
        <select id="genre_selector" onchange="changedSelector()">
            <option value="0"><%=bundle.getString("all_genre")%></option>
            <%
                for (Genre genre : HibernateUtils.getGenres()) {
                    String optionDefault = "";
                    if (Objects.equals(genre.getId().toString(), genreId))
                        optionDefault = "selected=\"selected\"";
            %>
            <option value='<%=genre.getId()%>' <%=optionDefault%>>
                <%=genre.getRightName(lang)%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div id="home_discount"><%=bundle.getString("discount")%></div>
</div>
<%
    List<Long> movieIds;
    if (genreId.equals("0")) {
        movieIds = HibernateUtils.getMoviesIds();
    } else {
        movieIds = HibernateUtils.getMovieIdsFromGenre(genreId);
    }
    for (Long movieId : movieIds) {
%>
<hr/>
<jsp:include page="movie_item.jsp">
    <jsp:param name="id" value='<%=movieId%>'/>
</jsp:include>

<%
    }
%>
<hr/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="scripts/home.js"></script>
</body>
</html>