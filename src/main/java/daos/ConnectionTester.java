package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTester {

    static final String URL = "jdbc:mysql://localhost:3306/car_dealership";
    static final String USER = "root";
    static final String PASSWORD = "zipcode0"; // Update as needed

    public static void main(String[] args) throws SQLException{
        // first TRY to load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
            return; // if driver not found ---> EXIT
        }

        // TRY w/ resources to ensure the connection is closed
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connection Established to MySQL");
        } catch (SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
