package org.oldcode.javaweb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.oldcode.javaweb.db.Conn;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainServlet extends HttpServlet {

    /*
    more then 2 levels is silly
    log.error("GET error ...");
    log.warn("GET warn ...");
    log.info("GET info ...");
    log.debug("GET debug ...");
    */
    private static final Logger log = LogManager.getLogger(MainServlet.class);

    private static Settings settings = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.debug("init() debug ...");
        if (settings == null) {
            settings = new Settings();
            settings.read();
            log.debug("init() settings read()");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", "name...");
        request.setAttribute("content_include", "_accounts.jsp");
        log.debug("doGet() plz dont crash");

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

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().print("main servlet POST");
    }

    public static Settings getSettings() {
        if (settings == null) {
            settings = new Settings();
            settings.read();
            log.debug("getSettings() settings read()");
        }
        return settings;
    }
}

