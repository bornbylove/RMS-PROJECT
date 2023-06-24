package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailInfo {
    private String id;

    private String productCode;
    private String productName;

    private int quantity;
    private double amount;
    private double price;
}
