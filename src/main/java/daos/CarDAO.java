package daos;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDAO implements DAO<CarDTO> {

    private static final String URL = "jdbc:mysql://localhost:3306/car_dealership";
    private static final String USER = "root";
    private static final String PASSWORD = "zipcode0"; // Update as needed

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
        List<CarDTO> cars = new ArrayList<>();
        String query = "SELECT * FROM car";
        try(Connection conn = getConnection();
        Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cars.add(new CarDTO(
                        rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("color"),
                        rs.getString("vin")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public CarDTO update(CarDTO car) {
        String query = "UPDATE car SET make = ?, model = ?, year = ?, color = ?, vin = ? WHERE id = ?";
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setString(4, car.getColor());
            pstmt.setString(5, car.getVin());
            pstmt.setInt(6, car.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public CarDTO create(CarDTO car) {
        String query = "INSERT INTO car (make, model, year, color, vin) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setInt(3, car.getYear());
            pstmt.setString(4, car.getColor());
            pstmt.setString(5, car.getVin());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                car = new CarDTO(
                        rs.getInt(1), // Generated ID
                        car.getMake(),
                        car.getModel(),
                        car.getYear(),
                        car.getColor(),
                        car.getVin()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM car WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}