package com.example.test_module3.dao;

import com.example.test_module3.dto.RentalDTO;

import java.sql.SQLException;
import java.util.List;

public interface RentalDAO {
    void addRental(RentalDTO rental) throws Exception;
    List<RentalDTO> getAllRentals() throws Exception;
    List<RentalDTO> searchRentals(String type, double price, int floor) throws Exception;
    void deleteRental(String rentalCode) throws Exception;
    boolean getRentalByCode(String rentalCode);
    void updateRental(RentalDTO rental) throws SQLException;
}

