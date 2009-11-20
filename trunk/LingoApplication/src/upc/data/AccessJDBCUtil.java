package upc.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessJDBCUtil {

    private static final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    private static final String accessDBURLSuffix = ";DriverID=22;READONLY=true}";

    private static org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(upc.view.LingoApplication.class).getContext().getResourceMap();
    private static String databasePath = resourceMap.getString("Application.database.path");

    public static Connection getAccessDBConnection()
            throws SQLException {

        System.out.println("databasePath " + databasePath);

        String filename = databasePath.replace('\\', '/').trim();

        StringBuilder urlBuffer = new StringBuilder();
        urlBuffer.append(accessDBURLPrefix);
        urlBuffer.append(filename);
        urlBuffer.append(accessDBURLSuffix);

        return DriverManager.getConnection(urlBuffer.toString(), "", "");
    }

    static {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("JdbcOdbc Bridge Driver not found!");
        }
    }
}
