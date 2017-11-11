import org.apache.log4j.Logger;
import utils.CartUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartPageServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(CartPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartUtils.addToSessionTicketPriceAndNumber(req.getSession());
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
        logger.debug("User opened cart page");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] movieId = req.getParameterValues("movieId[]");
        String[] tickets = req.getParameterValues("tickets[]");
        CartUtils.updateValues(req.getSession(), movieId, tickets);
        StringBuilder ticketsLine = new StringBuilder();
        for (int i = 0; i < movieId.length; i++) {
            ticketsLine.append("id #").append(movieId[i]).append(": ").append(tickets[i]).append(" tickets").append(";");
        }
        logger.debug("User added to cart: " + ticketsLine);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("id");
        CartUtils.deleteMovie(req.getSession(), Long.parseLong(movieId));
        logger.debug("User deleted from cart movie #" + movieId);
    }

}
