package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class Route {

    private static final Logger log = LogManager.getLogger(Route.class);

    public static void debugMethodPathEtc(HttpServletRequest r) {
        log.debug("context path: "+r.getContextPath());
        log.debug("method: "+r.getMethod());
        log.debug("path info: "+r.getPathInfo());
        log.debug("path translated: "+r.getPathTranslated());
        log.debug("request URI: "+r.getRequestURI());
        log.debug("request URL: "+r.getRequestURL());
        log.debug("servlet path: "+r.getServletPath());
    }

    public static RouteParts parseParts(HttpServletRequest r) {
        debugMethodPathEtc(r);

        String servletPath = r.getServletPath();
        if (servletPath.startsWith("/")) servletPath = servletPath.substring(1);
        log.debug("servlet path: "+servletPath);
        String[] parts = servletPath.split("\\.");
        for (String s: parts) {
            log.debug("ppart:"+s);
        }

        RouteParts rps = new RouteParts();
        if (parts != null && parts.length != 2) {
            rps.valid = false;
            return rps;
        }
        rps.version = parts[1];
        parts = (parts[0]).split("-+");
        for (String p: parts) {
           log.debug("p:"+p);
        }
        if (parts != null && parts.length < 2) {
            rps.valid = false;
            return rps;
        }
        rps.controller = parts[0];
        rps.method = parts[1];

        log.debug(rps);

        return rps;
    }

}
