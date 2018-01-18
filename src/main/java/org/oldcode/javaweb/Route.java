package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class Route {

    private static final Logger log = LogManager.getLogger(Route.class);

    public static RouteParts parseParts(HttpServletRequest r) {
        log.debug("context path: "+r.getContextPath());
        log.debug("method: "+r.getMethod());
        log.debug("path info: "+r.getPathInfo());
        log.debug("path translated: "+r.getPathTranslated());
        log.debug("request URI: "+r.getRequestURI());
        log.debug("request URL: "+r.getRequestURL());
        log.debug("servlet path: "+r.getServletPath());
/*
context path: /xyz
method: GET
path info: null
path translated: null
request URI: /xyz/controller-method.1
request URL: http://127.0.0.1:8080/xyz/controller-method.1
servlet path: /controller-method.1

the paths are blank if they came in on the blank match.
*/

        String servletPath = r.getServletPath();
        if (servletPath.startsWith("/")) servletPath = servletPath.substring(1);
        log.debug("servlet path: "+servletPath);
        String[] pparts = servletPath.split("\\.");
        for (String s: pparts) {
            log.debug("ppart:"+s);
        }

        return new RouteParts("contrl1", "method4");
    }

}
