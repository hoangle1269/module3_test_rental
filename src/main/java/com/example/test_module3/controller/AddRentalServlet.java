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
import java.sql.Date;
import java.time.format.DateTimeParseException;


@WebServlet(name = "addRentalServlet", urlPatterns = "/addRental")
public class AddRentalServlet extends HttpServlet {

    private RentalDAO rentalDAO = new RentalDAOImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/addRental.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String rentalCode = request.getParameter("rentalCode");
            String status = request.getParameter("status");
            double area = Double.parseDouble(request.getParameter("area"));
            int floor = Integer.parseInt(request.getParameter("floor"));
            String rentalType = request.getParameter("rentalType");
            BigDecimal price = new BigDecimal(request.getParameter("price"));
            Date startDate  = Date.valueOf(request.getParameter("startDate"));
            Date endDate  = Date.valueOf(request.getParameter("endDate"));


            RentalDTO rental = new RentalDTO(rentalCode, status, (float) area, floor, rentalType, price, startDate, endDate);

//            if (rentalDAO.getRentalByCode(rentalCode)) {
//                request.setAttribute("errorMessage", "Rental code already exists.");
//                request.getRequestDispatcher("/WEB-INF/views/addRental.jsp").forward(request, response);
//                return;
//            }

            rentalDAO.addRental(rental);

            response.sendRedirect(request.getContextPath() + "/listRentals");

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid number format.");
            request.getRequestDispatcher("/WEB-INF/views/addRental.jsp").forward(request, response);
        } catch (DateTimeParseException e) {
            request.setAttribute("errorMessage", "Invalid date format.");
            request.getRequestDispatcher("/WEB-INF/views/addRental.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to add rental: " + e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/addRental.jsp").forward(request, response);
        }
    }
}
