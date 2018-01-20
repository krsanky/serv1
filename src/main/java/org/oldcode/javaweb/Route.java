package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Route {

    private static final Logger log = LogManager.getLogger(Route.class);

    public String controller;
    public String method;
    public String version;
    public boolean valid;
    public Map<String, String> params; // these are specific to our naming scheme, not Servlet Request params

    public Route(String c, String m, String v) {
        controller = c;
        method = m;
        version = v;
        params = null;
        valid = false;
    }
    public Route(String c, String m) {
        this(c, m, null);
    }
    public Route() {
        this(null, null, null);
    }
    public Route(boolean valid) {
        controller = null;
        method = null;
        version = null;
        params = null;
        this.valid = valid;
    }

    public String toString() {
        return String.format("<Route controller:%s method:%s version:%s params:null>", controller, method, version);
    }

    public static void debugMethodPathEtc(HttpServletRequest r) {
        log.debug("context path: "+r.getContextPath());
        log.debug("method: "+r.getMethod());
        log.debug("path info: "+r.getPathInfo());
        log.debug("path translated: "+r.getPathTranslated());
        log.debug("request URI: "+r.getRequestURI());
        log.debug("request URL: "+r.getRequestURL());
        log.debug("servlet path: "+r.getServletPath());
    }

    public static Route parse(HttpServletRequest r) {
        debugMethodPathEtc(r);

        String servletPath = r.getServletPath();
        if (servletPath.startsWith("/")) servletPath = servletPath.substring(1);
        log.debug("servlet path: "+servletPath);
        String[] parts = servletPath.split("\\.");
        for (String s: parts) {
            log.debug("ppart:"+s);
        }

        Route route = new Route();
        if (parts != null && parts.length != 2) {
            route.valid = false;
            return route;
        }
        route.version = parts[1];
        parts = (parts[0]).split("-+");
        for (String p: parts) {
           log.debug("p:"+p);
        }
        if (parts != null && parts.length < 2) {
            route.valid = false;
            return route;
        }
        route.controller = parts[0];
        route.method = parts[1];
        // declare valid!
        route.valid = true;

        log.debug(route);

        return route;
    }

}
