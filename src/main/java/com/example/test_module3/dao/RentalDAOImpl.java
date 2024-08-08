package com.example.test_module3.dao;

import com.example.test_module3.dto.RentalDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.test_module3.service.DatabaseConnection.getConnection;

public class RentalDAOImpl implements RentalDAO {

    @Override
    public void addRental(RentalDTO rental) throws Exception {
        String query = "INSERT INTO rentals (rental_code, status, area, floor, rental_type, price, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rental.getRentalCode());
            stmt.setString(2, rental.getStatus());
            stmt.setFloat(3, rental.getArea());
            stmt.setInt(4, rental.getFloor());
            stmt.setString(5, rental.getRentalType());
            stmt.setBigDecimal(6, rental.getPrice());
            stmt.setDate(7, Date.valueOf(rental.getStartDate()));
            stmt.setDate(8, Date.valueOf(rental.getEndDate()));
            stmt.executeUpdate();
        }
    }

    @Override
    public List<RentalDTO> getAllRentals() throws Exception {
        String query = "SELECT * FROM rentals ORDER BY area ASC";
        List<RentalDTO> rentals = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                RentalDTO rental = new RentalDTO(
                        rs.getString("rental_code"),
                        rs.getString("status"),
                        rs.getFloat("area"),
                        rs.getInt("floor"),
                        rs.getString("rental_type"),
                        rs.getBigDecimal("price"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate()
                );
                rentals.add(rental);
            }
        }
        return rentals;
    }

    @Override
    public List<RentalDTO> searchRentals(String type, double price, int floor) throws Exception {
        String query = "SELECT * FROM rentals WHERE rental_type = ? AND price <= ? AND floor = ? ORDER BY area ASC";
        List<RentalDTO> rentals = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setDouble(2, price);
            stmt.setInt(3, floor);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RentalDTO rental = new RentalDTO(
                            rs.getString("rental_code"),
                            rs.getString("status"),
                            rs.getFloat("area"),
                            rs.getInt("floor"),
                            rs.getString("rental_type"),
                            rs.getBigDecimal("price"),
                            rs.getDate("start_date").toLocalDate(),
                            rs.getDate("end_date").toLocalDate()
                    );
                    rentals.add(rental);
                }
            }
        }
        return rentals;
    }

    @Override
    public void deleteRental(String rentalCode) throws Exception {
        String query = "DELETE FROM rentals WHERE rental_code = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rentalCode);
            stmt.executeUpdate();
        }
    }

    @Override
    public boolean getRentalByCode(String rentalCode) {
        String query = "SELECT COUNT(*) FROM rentals WHERE rental_code = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, rentalCode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateRental(RentalDTO rental) throws SQLException{
        String query = "UPDATE rentals SET status = ?, area = ?, floor = ?, rental_type = ?, price = ?, start_Date = ?, end_Date = ? WHERE rentals.rental_code = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, rental.getStatus());
            stmt.setDouble(2, rental.getArea());
            stmt.setInt(3, rental.getFloor());
            stmt.setString(4, rental.getRentalType());
            stmt.setBigDecimal(5, rental.getPrice());
            stmt.setDate(6, java.sql.Date.valueOf(rental.getStartDate()));
            stmt.setDate(7, java.sql.Date.valueOf(rental.getEndDate()));
            stmt.setString(8, rental.getRentalCode());

            stmt.executeUpdate();
        }
    }

}

