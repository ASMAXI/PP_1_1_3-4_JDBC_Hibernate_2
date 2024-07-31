package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Util {
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

    private static final String DB_HOST = "localhost";
    private static final String DB_NAME = "my_connection";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "bestuser";
    private static final String DB_PASS = "bestuser";

    private static Util instance;
    private Connection dbConnection;

    private Util() {}

    public static synchronized Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public Connection getDbConnection() throws SQLException {
        if (dbConnection == null || dbConnection.isClosed()) {
            String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
            dbConnection = DriverManager.getConnection(connectionString, DB_USER, DB_PASS);
        }
        return dbConnection;
    }
}
