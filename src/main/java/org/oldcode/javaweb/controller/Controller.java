package org.oldcode.javaweb.controller;

import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    // the base case implements this, so it's redundant here
    // but it shows it's necesary
    void handleRequest(
            Route route,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException;

    void defaultMethod(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException;
}
