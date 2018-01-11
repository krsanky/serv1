package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private static final Logger log = LogManager.getLogger(MainServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.error("GET error ...");
        log.info("GET info ...");
        log.debug("GET debug ...");
        log.warn("GET warn ...");
        /*
        */
        response.getWriter().print("main servlet GET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("main servlet POST");
    }

}

