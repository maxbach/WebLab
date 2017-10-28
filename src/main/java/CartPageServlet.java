import utils.CartUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class CartPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartUtils.addToSessionTicketPriceAndNumber(req.getSession());
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] movieId = req.getParameterValues("movieId[]");
        String[] tickets = req.getParameterValues("tickets[]");
        CartUtils.updateValues(req.getSession(), movieId, tickets);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("id");
        CartUtils.deleteMovie(req.getSession(), Long.parseLong(movieId));
    }

}
