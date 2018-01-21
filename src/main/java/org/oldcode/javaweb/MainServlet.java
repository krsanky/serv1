package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.controller.Account;
import org.oldcode.javaweb.controller.Controller;
import org.oldcode.javaweb.controller.Main;
import org.oldcode.javaweb.controller.Test1;

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

    private void addControllers() {
        controllers.put("test1", new Test1());
        controllers.put("account", new Account());
        controllers.put("default", new Main());
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

        log.debug("doGet() plz dont crash");

        //response.getWriter().print("main servlet POST");

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

