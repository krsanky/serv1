package org.oldcode.javaweb.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;


// A web application has to explicitly close ResultSet's, Statement's, and Connection's.
public class Conn {

    private static final Logger log = LogManager.getLogger(Conn.class);

    public void getAccounts() {
        log.debug("Conn.getAccounts()...");
    }

    public void testConn() {
        /*
        Settings settings = MainServlet.getSettings();
        String user = settings.get("db_user");
        String password = settings.get("db_password");
        String name = settings.get("db_name");
        String url = String.format("jdbc:postgresql://localhost/%s?user=%s&password=%s", name, user, password);
        try {
            Connection conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        */

        // scratch the above, we use tomcat for DBCP connections
        try {
            InitialContext cxt = new InitialContext();
            if (cxt == null) {
                //throw new Exception("Uh oh -- no context!");
                log.error("InitalContext is null ... bad");
            }

            DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");

            if (ds == null) {
                //throw new Exception("Data source not found!");
                log.error("DataSource is null ... bad");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}

