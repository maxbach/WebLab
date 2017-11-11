import org.apache.log4j.Logger;
import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(HomePageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String lang = CookieUtils.getLanguageCookie(req, resp);
        String genreId = req.getParameter("genre");
        if (genreId == null) {
            genreId = CookieUtils.getGenreCookie(req, resp);
        }
        req.setAttribute("lang", lang);
        req.setAttribute("genre", genreId);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
        logger.debug("User opened home page");
    }
}
