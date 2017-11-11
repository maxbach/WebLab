import org.apache.log4j.Logger;
import utils.AuthUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginPageServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(LoginPageServlet.class);

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("User " + req.getUserPrincipal().getName() + "does logout");
        AuthUtils.logout(req);
    }
}
