package RumahSakit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tb12as
 */
public class Database {

    public static Connection initConnection() {
        try {
            // Step 1: Registrasi atau lood JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Ciptakan dan bangun koneksi ke database "rumah_sakit"
            String url = "jdbc:mysql://localhost/rumah_sakit";
            String user = "root";
            String password = "root";

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

    public static Statement initStatement() {
        try {
            return initConnection().createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }
}
