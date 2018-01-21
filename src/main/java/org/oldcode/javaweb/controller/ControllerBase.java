package org.oldcode.javaweb.controller;

import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

abstract public class ControllerBase implements Controller {
    public void render(
            HttpServletRequest request,
            HttpServletResponse response,
            String template) throws ServletException, IOException {
        request.setAttribute("content_include", template);
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    public void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            Route route) throws ServletException, IOException {
        defaultMethod(request, response);
    }

    public void defaultMethod(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        render(request, response, "_default.jsp");
    }

    public void doDefaultMethod(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Map controllers = (Map) request.getServletContext().getAttribute("org.oldcode.javaweb.controllers");
        Controller def = (Controller) controllers.get("default");
        def.defaultMethod(request, response);
    }
}
