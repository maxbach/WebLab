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
        return getCookie(req, resp, "lang", "en");
    }

    public static String getGenreCookie(HttpServletRequest req, HttpServletResponse resp) {
        return getCookie(req, resp, "genre", "0");
    }

    private static String getCookie(HttpServletRequest req, HttpServletResponse resp, String id, String defaultValue) {
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals(id)) {
                    return cookie.getValue();
                }
            }
        }
        resp.addCookie(new Cookie(id, defaultValue));
        return defaultValue;
    }
}
