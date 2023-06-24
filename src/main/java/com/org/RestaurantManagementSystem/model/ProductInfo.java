package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductInfo {
    private String code;
    private String name;

    private double price;

    public ProductInfo(String code, String name, double price) {
    }

    public double getPrice() {
        return this.price;
    }

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }
}
