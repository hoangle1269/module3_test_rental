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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "updateRentalServlet", urlPatterns = "/updateRental")
public class UpdateRentalServlet extends HttpServlet {

    private RentalDAO rentalDAO = new RentalDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rentalCode = request.getParameter("rentalCode");
        boolean rental = rentalDAO.getRentalByCode(rentalCode);
        request.setAttribute("rental", rental);
        request.getRequestDispatcher("/WEB-INF/views/updateRental.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rentalCode = request.getParameter("rentalCode");
            String status = request.getParameter("status");
            double area = Double.parseDouble(request.getParameter("area"));
            int floor = Integer.parseInt(request.getParameter("floor"));
            String rentalType = request.getParameter("rentalType");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            String startDateStr = request.getParameter("startDate");
            String endDateStr = request.getParameter("endDate");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate startDate = LocalDate.parse(startDateStr, formatter);
            LocalDate endDate = LocalDate.parse(endDateStr, formatter);

            RentalDTO rental = new RentalDTO(rentalCode, status, area, floor, rentalType, price, startDate, endDate);

            // Update rental in database
            rentalDAO.updateRental(rental);

            // Redirect to list rentals page
            response.sendRedirect(request.getContextPath() + "/listRentals");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to update rental: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/updateRental.jsp").forward(request, response);
        }
    }
}

