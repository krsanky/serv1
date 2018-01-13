package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.db.Conn;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(MainServlet.class);
    private static Settings settings = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.debug("init() debug ...");
        if (settings == null) {
            settings = new Settings();
            settings.read();
            log.debug("init() settings read()");
        }

        /*
        log.error("GET error ...");
        log.info("GET info ...");
        log.debug("GET debug ...");
        log.warn("GET warn ...");
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", "name...");
        request.setAttribute("content_include", "_accounts.jsp");
        log.debug("doGet() plz dont crash");

        Conn c = new Conn();
        c.testConn();
        log.debug("doGet() .testConn() worked :)");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("main servlet POST");
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

