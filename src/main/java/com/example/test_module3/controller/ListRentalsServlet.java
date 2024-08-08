package com.example.test_module3.controller;

import com.example.test_module3.dao.RentalDAO;
import com.example.test_module3.dao.RentalDAOImpl;
import com.example.test_module3.dto.RentalDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listRentalsServlet", urlPatterns = "/listRentals")
public class ListRentalsServlet extends HttpServlet {

    private RentalDAO rentalDAO = new RentalDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<RentalDTO> rentals = rentalDAO.getAllRentals();
            request.setAttribute("rentals", rentals);
            request.getRequestDispatcher("/WEB-INF/views/listRentals.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to fetch rentals: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

