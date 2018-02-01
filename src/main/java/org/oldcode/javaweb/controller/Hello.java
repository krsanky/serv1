package org.oldcode.javaweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Hello extends ControllerBase {
    private static final Logger log = LogManager.getLogger(Hello.class);

    @Override
    public void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            Route route) throws ServletException, IOException {
        log.debug("Here in Hello controller");
        switch (route.method) {
            case "main": main(request, response); break;
            case "test":
                request.setAttribute("id", route.version);
                test(request, response);
                break;
            default:
                doDefaultMethod(request, response);
        }
    }

    private void test(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String id = (String)request.getAttribute("id");
        response.getWriter().print(String.format("<p>Hello:%s</p>", id));
    }

    private void main(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/hello/main.jsp").forward(request, response);
    }
/*
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name == null) name = "World";
        request.setAttribute("user", name);
        request.getRequestDispatcher("jsp/response.jsp").forward(request, response);
    }
    */
}

