import utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String lang = CookieUtils.getLanguageCookie(req, resp);
        String defaultGenreId = CookieUtils.getGenreCookie(req, resp);
        req.setAttribute("lang", lang);
        req.setAttribute("genre", defaultGenreId);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
