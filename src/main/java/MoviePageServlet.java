import Entities.Movie;
import utils.CookieUtils;
import utils.HibernateUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MoviePageServlet extends HttpServlet {

    private String iniLineJavascript;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Integer param = Integer.parseInt(config.getInitParameter("firstPage"));
        switch (param) {
            case 1:
                iniLineJavascript = "showMain()";
                break;
            case 2:
                iniLineJavascript = "showLong()";
                break;
            default:
                iniLineJavascript = "showReview()";
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lang = CookieUtils.getLanguageCookie(req, resp);
        String id = req.getParameter("id");

        Movie movie = HibernateUtils.getMovie(Long.parseLong(id));
        resp.setContentType("text/html;charset=utf-8");
        req.setAttribute("movie", movie.getMovieLanguage(lang));
        req.setAttribute("initMethod", iniLineJavascript);
        req.setAttribute("lang", lang);
        req.getRequestDispatcher("movie_page.jsp").forward(req, resp);
    }



}
