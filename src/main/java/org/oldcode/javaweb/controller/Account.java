package org.oldcode.javaweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.oldcode.javaweb.Password;
import org.oldcode.javaweb.Route;
import org.oldcode.javaweb.db.Conn;
import org.oldcode.javaweb.generated.jooq.public_.tables.records.AccountRecord;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import static org.oldcode.javaweb.generated.jooq.public_.tables.Account.ACCOUNT;
//import static test.generated.Tables.*;

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

        Conn conn = new Conn();
        Result<Record> accounts = null;
        Connection c = null;
        try {
            c = conn.getConnection();
            DSLContext create = DSL.using(c, SQLDialect.POSTGRES);

            if ("POST".equals(request.getMethod())) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                if (username != null && password != null && password.length() > 0) {
                    String hpass = Password.hash(password);
                    log.debug("username:" + username + " password:" + password + " HASH:" + hpass);
                    AccountRecord acct = create.newRecord(ACCOUNT);
                    acct.setUsername(username);
                    acct.setPassword(password);
                    acct.store();
                }
            }

            accounts = create.select().from(ACCOUNT).fetch();
            log.debug("accounts: type: "+accounts.getClass());
            for (Record r : accounts) {
                Integer id = r.getValue(ACCOUNT.ID);
                String firstName = r.getValue(ACCOUNT.USERNAME);
                String lastName = r.getValue(ACCOUNT.EMAIL);

                log.debug("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }
            request.setAttribute("users", accounts);

        } catch (Exception e) {
            log.debug("EXC:"+e.getMessage());
            e.printStackTrace();
        }

        log.debug("last in admin");
        render(request, response, "account/admin.jsp");
    }
}



