package com.example.demo.onlineshop.http;

import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;

public class HttpRequestUtils {

    public static Optional<HttpServletRequest> getCurrentRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) getRequestAttributes();
        return ofNullable(attributes)
                .map(ServletRequestAttributes::getRequest);
    }
}
