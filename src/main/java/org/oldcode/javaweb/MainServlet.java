package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.controller.Controller;
import org.oldcode.javaweb.controller.Test1;
import org.oldcode.javaweb.db.Conn;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainServlet extends HttpServlet {

    /*
    more then 2 levels is silly
    log.error("GET error ...");
    log.warn("GET warn ...");
    log.info("GET info ...");
    log.debug("GET debug ...");
    */
    private static final Logger log = LogManager.getLogger(MainServlet.class);

    private static Settings settings = null;

    private Map<String, Controller> controllers = null;

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
        controllers.put("test1", new Test1());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", "name...");

        log.debug("doGet() plz dont crash");

        //response.getWriter().print("main servlet POST");

        controllers.get("test1").Do(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public static Settings getSettings() {
        if (settings == null) {
            settings = new Settings();
            settings.read();
            log.debug("getSettings() settings read()");
        }
        return settings;
    }
}

