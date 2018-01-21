package org.oldcode.javaweb.controller;

import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            Route route) throws ServletException, IOException;

    void defaultMethod(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException;
}
