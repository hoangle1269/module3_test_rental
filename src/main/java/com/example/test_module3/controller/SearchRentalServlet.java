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
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "searchRentalServlet", urlPatterns = "/searchRental")
public class SearchRentalServlet extends HttpServlet {

    private RentalDAO rentalDAO = new RentalDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rentalType = request.getParameter("rentalType");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            int floor = Integer.parseInt(request.getParameter("floor"));

            List<RentalDTO> rentals = rentalDAO.searchRentals(rentalType, price.doubleValue(), floor);
            request.setAttribute("rentals", rentals);
            request.getRequestDispatcher("/WEB-INF/views/listRentals.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to search rentals: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

