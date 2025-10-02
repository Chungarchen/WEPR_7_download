package murach.util;

import jakarta.servlet.http.*;

public class CookieUtil {
    public static Cookie getCookie(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookieName.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }
}
