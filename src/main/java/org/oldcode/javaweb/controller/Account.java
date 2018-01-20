package org.oldcode.javaweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Account extends ControllerBase { //} implements Controller {
    private static final Logger log = LogManager.getLogger(Account.class);

    @Override
    public void handleRequest(Route route, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Here in Account controller");
        switch (route.method) {
            case "login":
                login(request, response);
                break;
            default:
                doDefaultMethod(request, response);
        }
    }

    private void login(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("Here in login method");
        render("account/_login.jsp", request, response);
    }
}
