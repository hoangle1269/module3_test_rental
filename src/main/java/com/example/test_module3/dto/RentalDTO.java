package com.example.test_module3.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class RentalDTO {
    private String rentalCode;
    private String status;
    private float area;
    private int floor;
    private String rentalType;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;


    public RentalDTO(String rentalCode, String status, double area, int floor, String rentalType, BigDecimal price, Date startDate, Date endDate) {
        this.rentalCode = rentalCode;
        this.status = status;
        this.area = (float) area;
        this.floor = floor;
        this.rentalType = rentalType;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRentalCode() {
        return rentalCode;
    }

    public void setRentalCode(String rentalCode) {
        this.rentalCode = rentalCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

