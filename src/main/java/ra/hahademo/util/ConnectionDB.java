package ra.hahademo.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/Ecommerce_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "Dcmm2003@";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection openGetConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
