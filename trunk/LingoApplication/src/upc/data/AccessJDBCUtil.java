package upc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author pablo.sierralta
 */
public class AccessJDBCUtil {

    private static final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    private static final String accessDBURLSuffix = ";DriverID=22;READONLY=true}";

    public static Connection getAccessDBConnection()
            throws SQLException {

        Properties parameters = Parameters.getInstance();
        String databasePath = parameters.getProperty("database.path");
        String user = parameters.getProperty("database.user");
        String pass = parameters.getProperty("database.pass");

        String filename = databasePath.replace('\\', '/').trim();

        StringBuilder urlBuffer = new StringBuilder();
        urlBuffer.append(accessDBURLPrefix);
        urlBuffer.append(filename);
        urlBuffer.append(accessDBURLSuffix);
        return DriverManager.getConnection(urlBuffer.toString(), user, pass);
    }

    static {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("JdbcOdbc Bridge Driver not found!");
        }
    }
}
