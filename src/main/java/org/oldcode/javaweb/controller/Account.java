package org.oldcode.javaweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.Password;
import org.oldcode.javaweb.Route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Account extends ControllerBase { //} implements Controller {
    private static final Logger log = LogManager.getLogger(Account.class);

    @Override
    public void handleRequest(
            HttpServletRequest request,
            HttpServletResponse response, Route route) throws ServletException, IOException {
        log.debug("Here in Account controller");
        switch (route.method) {
            case "login": login(request, response); break;
            case "admin": admin(request, response); break;
            default:
                doDefaultMethod(request, response);
        }
    }

    private void login(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("Here in login, method: "+ request.getMethod());

        if ("POST".equals(request.getMethod())) {
            log.debug("POST POST POST");

        }
        request.setAttribute("content_include","account/_login.jsp");
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

    private void admin(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        log.debug("Here in admin, method: "+ request.getMethod());

        if ("POST".equals(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String hpass = Password.hash(password);
            log.debug("username:"+username+" password:"+password+" HASH:"+hpass);
        }

        render(request, response, "account/admin.jsp");
    }
}



