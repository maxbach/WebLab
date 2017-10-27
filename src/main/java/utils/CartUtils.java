package utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class CartUtils {

    private static final Long ONE_TICKET = 5L;

    public static Long getCountSum(HttpSession session) {
        int count = 0;
        for (Map.Entry<Long, Integer> o : getCart(session).entrySet()) {
            count += o.getValue();
        }
        return count * ONE_TICKET;
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
}
