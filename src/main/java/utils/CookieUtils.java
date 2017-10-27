package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static String getLocale(HttpServletRequest req, HttpServletResponse resp) {
        String lang = getLanguageCookie(req, resp);
        switch (lang) {
            case "ru":
                return "ru_RU";
            case "fr":
                return "fr_FR";
            default:
                return "en_GB";
        }
    }

    public static String getLanguageCookie(HttpServletRequest req, HttpServletResponse resp) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("lang")) {
                return cookie.getValue();
            }
        }
        resp.addCookie(new Cookie("lang", "en"));
        return "en";
    }

    public static String getGenreCookie(HttpServletRequest req, HttpServletResponse resp) {
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("genre")) {
                return cookie.getValue();
            }
        }
        resp.addCookie(new Cookie("genre", "0"));
        return "0";
    }
}
