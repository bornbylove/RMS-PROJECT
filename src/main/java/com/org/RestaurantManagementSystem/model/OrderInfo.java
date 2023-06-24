package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
public class OrderInfo {
    private String id;
    private Date orderDate;
    private int orderNum;
    private double amount;

    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;

    private List<OrderDetailInfo> details;

    public OrderInfo(String id, Date orderDate, int orderNum, double amount, String customerName, String customerAddress, String customerEmail, String customerPhone) {
    }
}
