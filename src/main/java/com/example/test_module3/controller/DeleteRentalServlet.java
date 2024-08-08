package com.example.test_module3.controller;

import com.example.test_module3.dao.RentalDAO;
import com.example.test_module3.dao.RentalDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteRentalServlet", urlPatterns = "/deleteRental")
public class DeleteRentalServlet extends HttpServlet {

    private RentalDAO rentalDAO = new RentalDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rentalCode = request.getParameter("rentalCode");
            rentalDAO.deleteRental(rentalCode);
            response.sendRedirect(request.getContextPath() + "/listRentals");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to delete rental: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

