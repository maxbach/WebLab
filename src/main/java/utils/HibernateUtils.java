package utils;

import Entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class HibernateUtils {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static Movie getMovie(String id) {
        try {
            return getMovie(Long.parseLong(id));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Movie getMovie(long id) {
        try (Session session = getSession()) {
            return session.get(Movie.class, id);
        }
    }

    public static List<Long> getMoviesIds() {
        try (Session session = getSession()) {
            return session.createQuery("SELECT id from Movie").getResultList();
        }
    }

    public static List<Genre> getGenres() {
        try (Session session = getSession()) {
            return session.createQuery("from Genre", Genre.class).getResultList();
        }
    }

    public static List<Long> getMovieIdsFromGenre(String genre) {
        try (Session session = getSession()) {
            return session.createQuery("SELECT id from Movie where id=:genre")
                    .setParameter("genre", Long.parseLong(genre))
                    .getResultList();

        }
    }

    public static void addOrder(HttpSession session, Principal user, Boolean isPickup, String shopId, String address) {
        Order order;
        String nowDate = ISODateTimeFormat.dateTime().print(new DateTime());
        if (isPickup) {
            order = new Order(user.getName(), nowDate, true, getCinema(Long.parseLong(shopId)), null);
        } else {
            order = new Order(user.getName(), nowDate,false, null, address);
        }
        addEntity(order);
        CartUtils.getCart(session).forEach((key, value) -> addEntity(new OrderDetail(value, order, getMovie(key))));
    }

    public static List<Comment> getCommentOfUser(HttpServletRequest req) {
        String login = AuthUtils.getUserName(req);
        try (Session session = getSession()) {
            return session.createQuery("from Comment where userLogin=:login")
                    .setParameter("login", login)
                    .getResultList();
        }
    }

    public static List<Shop> getShops() {
        try (Session session = getSession()) {
            return session.createQuery("from Shop").getResultList();
        }
    }

    public static List<Order> getOrdersOfUser(HttpServletRequest req) {
        String login = AuthUtils.getUserName(req);
        try (Session session = getSession()) {
            List<Order> orders = session.createQuery("from Order where userLogin=:login")
                    .setParameter("login", login)
                    .getResultList();
            for (Order order : orders) {
                order.setDetails(session.createQuery("from OrderDetail where order.id=:id")
                        .setParameter("id", order.getId()).getResultList());
            }
            return orders;
        }
    }

    public static void addEntity(Object object) {
        try (Session session = getSession()) {
            Transaction t = session.beginTransaction();
            session.save(object);
            t.commit();
        }
    }

    public static Shop getCinema(long id) {
        try (Session session = getSession()) {
            return (Shop) session.createQuery("from Shop where id=:id").setParameter("id", id).getSingleResult();
        }
    }

}