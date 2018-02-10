package org.oldcode.javaweb;

import com.mitchellbosecke.pebble.PebbleEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.controller.*;
import org.oldcode.javaweb.controller.Main;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(MainServlet.class);

    private Settings settings = null;
    private Map<String, Controller> controllers = null;
    private PebbleEngine templateEngine;

    private void addControllers() {
        controllers.put("test1", new Test1());
        controllers.put("account", new Account());
        controllers.put("default", new Main());
        controllers.put("hello", new Hello());
        controllers.put("rtw", new Rtw());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.debug("init() debug ...");

        if (settings == null) {
            settings = new Settings();
            settings.read();
            log.debug("init() settings read()");
        }
        controllers = new HashMap<>();
        addControllers();
        ServletContext ctx = config.getServletContext();

        ctx.setAttribute("org.oldcode.javaweb.controllers", controllers);
        ctx.setAttribute("org.oldcode.javaweb.settings", settings);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setAttribute("user", "name...");
        Route route = Route.parse(request);
        log.debug("Route: "+route);

        if (controllers.containsKey(route.controller)) {
            controllers.get(route.controller).handleRequest(request, response, route);
        } else {
            controllers.get("test1").handleRequest(request, response, route);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}

