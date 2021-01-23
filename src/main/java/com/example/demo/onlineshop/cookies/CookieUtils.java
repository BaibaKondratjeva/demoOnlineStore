package com.example.demo.onlineshop.cookies;

import com.example.demo.onlineshop.http.HttpRequestUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static final int COOKIE_DEFAULT_MAX_AGE_SECONDS = 60 * 60 * 24 * 30;
    public static final String COOKIE_PATH = "/";

    public static Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(COOKIE_DEFAULT_MAX_AGE_SECONDS);
        cookie.setPath(COOKIE_PATH);
        return cookie;
    }

    public static String getCookieValueByName(String cookieName) {
        return HttpRequestUtils.getCurrentRequest()
                .map(request -> WebUtils.getCookie(request, cookieName))
                .map(Cookie::getValue)
                .orElse(null);
    }
}
