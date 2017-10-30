package utils;

import javax.servlet.http.HttpServletRequest;

public class AuthUtils {
    public static String getUserName(HttpServletRequest req) {
        if (req.getUserPrincipal() == null) {
            return "";
        } else {
            return req.getUserPrincipal().getName();
        }
    }

    public static void logout(HttpServletRequest req) {
        req.getSession().invalidate();
    }
}
