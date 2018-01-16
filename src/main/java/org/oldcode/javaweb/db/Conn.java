package org.oldcode.javaweb.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;


// A web application has to explicitly close ResultSet's, Statement's, and Connection's.
public class Conn { //change name to some variation of database? or DbUtil ? dbstuff Database ...

    private static final Logger log = LogManager.getLogger(Conn.class);

    public void getAccounts() {
        log.debug("Conn.getAccounts()...");
    }

    public DataSource getDataSource() throws Exception {

        InitialContext cxt = new InitialContext();
        if (cxt == null) {
            log.error("InitalContext is null ... bad");
            throw new Exception("Uh oh -- no context!");
        }

        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");

        if (ds == null) {
            log.error("DataSource is null ... bad");
            throw new Exception("Data source not found!");
        }
        return ds;
    }

    public void testConn() {
        // mv the jdbc example from MainServlet here?
    }

}

