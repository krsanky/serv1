package org.oldcode.javaweb.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.Route;
import org.oldcode.javaweb.db.Conn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test1 extends ControllerBase {

    private static final Logger log = LogManager.getLogger(Test1.class);
    //private Map<String, >

    @Override
    public void handleRequest(Route route, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PreparedStatement ps = null;
        String sql = "SELECT id, password, username, email, is_active "+
                "FROM account";
        // "FROM account WHERE id= ?";

        Conn conn = new Conn();
        conn.testConn();
        log.debug("doGet() .testConn() worked :)");
        log.error("GET error ...");
        log.debug("GET debug ...");

        DataSource ds;
        Connection c;
        try {
            ds = conn.getDataSource();
            if (ds == null)
                log.debug("ds == null");
            c = ds.getConnection();

            ps = c.prepareStatement(sql);
            //ps.setInt(1, 1001);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                log.debug("id : " + id);
                log.debug("username : " + username);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        request.setAttribute("content_include", "stuff123.jsp");
        request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
    }

}




