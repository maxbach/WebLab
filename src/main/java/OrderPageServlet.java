import org.apache.log4j.Logger;
import utils.CartUtils;
import utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderPageServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(OrderPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("order.jsp").forward(req, resp);
        logger.debug("User " + req.getUserPrincipal().getName() + " opened order page");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isPickup = req.getParameter("isPickup").equals("true");
        String shopId = req.getParameter("shopId");
        String address = req.getParameter("address");
        HibernateUtils.addOrder(req.getSession(), req.getUserPrincipal(), isPickup, shopId, address);
        logger.debug("User " + req.getUserPrincipal().getName() + " made new order");
        CartUtils.cleanCart(req.getSession());
    }


}
