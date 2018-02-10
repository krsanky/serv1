package org.oldcode.javaweb.controller;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.Route;
import org.oldcode.javaweb.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Rtw extends ControllerBase {
    private static final Logger log = LogManager.getLogger(Rtw.class);

    @Override
    public void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            Route route) throws ServletException, IOException {
        log.debug("Rtw controller handleRequest");
        switch (route.method) {
            case "index": index(request, response); break;
            case "index2": index2(request, response); break;
            default:
                doDefaultMethod(request, response);
        }
    }

    private void index(
            HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException {
        log.debug("Rtw index() method: "+ request.getMethod());

        if ("POST".equals(request.getMethod())) {
            log.debug("POST POST POST");

        }
        request.setAttribute("content_include","rtw/index.jsp");
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    private void index2(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("Rtw index2() method: "+ request.getMethod());
        if ("POST".equals(request.getMethod())) {
            log.debug("POST");
        }
        Map<String, Object> context = new HashMap<>();
        context.put("name", "JAmJAMHJAM");
        View.Render(request, response, "rtw/index.html", context);
    }
}
