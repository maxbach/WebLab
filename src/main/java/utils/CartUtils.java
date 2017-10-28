package utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class CartUtils {

    private static final Long ONE_TICKET = 5L;

    public static int getCountSum(HttpSession session) {
        int count = 0;
        for (Map.Entry<Long, Integer> o : getCart(session).entrySet()) {
            count += o.getValue();
        }
        return count;
    }

    public static void addToSessionTicketPriceAndNumber(HttpSession session) {
        session.setAttribute("numberOfTickets", String.valueOf(getCountSum(session)));
        session.setAttribute("ticketPrice", String.valueOf(ONE_TICKET));
    }

    public static Map<Long, Integer> getCart(HttpSession session) {
        Object cart = session.getAttribute("cart");
        if (cart != null && cart instanceof Map) {
            return (Map<Long, Integer>) cart;
        } else {
            Map<Long, Integer> newCart = new HashMap<>();
            session.setAttribute("cart", newCart);
            return newCart;
        }
    }

    public static void addTicketsToCart(HttpSession session, Long filmId, Integer tickets) {
        Map<Long, Integer> cart = getCart(session);
        cart.merge(filmId, tickets, (a, b) -> {
            if (a + b > 0) return a + b;
            else return 1;
        });
    }

    public static void deleteMovie(HttpSession session, Long filmId) {
        getCart(session).remove(filmId);
    }

    public static void updateValues(HttpSession session, String[] movieIds, String[] values) {
        for (int i = 0; i < movieIds.length; i++) {
            addTicketsToCart(session, Long.parseLong(movieIds[i]), Integer.parseInt(values[i]));
        }
    }
}
