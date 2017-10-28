package utils;

import Entities.Genre;
import Entities.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            return session.createQuery("SELECT id from Movie where genre.id=:genre")
                    .setParameter("genre", Long.parseLong(genre))
                    .getResultList();

        }
    }

}