import Entities.Comment;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import utils.HibernateUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentsPageServlet extends HttpServlet {

    final static Logger logger = Logger.getLogger(CommentsPageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("comments.jsp").forward(req, resp);
        logger.debug("User " + req.getUserPrincipal().getName() + " updates comments");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtils.addEntity(new Comment(req.getUserPrincipal().getName(), req.getParameter("commentText"),
                ISODateTimeFormat.dateTime().print(new DateTime())));
        logger.debug("User " + req.getUserPrincipal().getName() + " added comment \"" + req.getParameter("commentText") + "\"");
    }
}
