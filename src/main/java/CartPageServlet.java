import utils.CartUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieId = req.getParameter("movieId");
        String tickets = req.getParameter("tickets");
        CartUtils.addTicketsToCart(req.getSession(), Long.parseLong(movieId), Integer.parseInt(tickets));

        resp.setContentType("text/html;charset=utf-8");
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }
}
