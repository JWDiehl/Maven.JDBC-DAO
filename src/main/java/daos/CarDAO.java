package daos;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class CarDAO implements DAO<CarDTO> {

    private static final String URL = "jdbc:mysql://localhost:3306/car_dealership";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Update as needed

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public CarDTO findById(int id) {
        String query = "SELECT * FROM car WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new CarDTO(
                        rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("Year"),
                        rs.getString("color"),
                        rs.getString("vin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CarDTO> findAll() {
        return Collections.emptyList();
    }

    @Override
    public CarDTO update(CarDTO dto) {
        return null;
    }

    @Override
    public CarDTO create(CarDTO dto) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
