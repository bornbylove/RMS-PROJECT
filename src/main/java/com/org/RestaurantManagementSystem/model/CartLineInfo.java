package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class CartLineInfo {
    private ProductInfo productInfo;
    private int quantity;

    private double amount;

    public double getAmount(){
        return this.productInfo.getPrice() * this.quantity;
    }

    public ProductInfo getProductInfo() {
        return this.productInfo;
    }

    public void setQuantity(int i) {
    }

    public void setProductInfo(ProductInfo productInfo) {
    }

    public int getQuantity() {
        return this.quantity;
    }
}
