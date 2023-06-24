package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class CartInfo {
    private int orderNum;
    private CustomerInfo customerInfo;
    private final List<CartLineInfo> cartLines = new ArrayList<>();

    public List<CartLineInfo> findLineByCode(String code){
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getCode().equals(code)) {
                return findLineByCode(code);
            }
        }
        return null;
    }

    public List<CartLineInfo> getCartLines(){
        return this.cartLines;
    }

    public void addProduct(ProductInfo productInfo, int quantity){
        CartLineInfo line = (CartLineInfo) this.findLineByCode(productInfo.getCode());

        if (line == null){
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0){
            this.cartLines.remove(line);
        }else {
            line.setQuantity(newQuantity);
        }
    }

    public void updateProduct(String code, int quantity){
        CartLineInfo line = (CartLineInfo) this.findLineByCode(code);

        if (line != null){
            if (quantity < 0){
                this.cartLines.remove(line);
            }else {
                line.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(ProductInfo productInfo){
        CartLineInfo line = (CartLineInfo) this.findLineByCode(productInfo.getCode());
        if (line != null){
            this.cartLines.remove(line);
        }
    }

    public boolean isEmpty(){
        return this.cartLines.isEmpty();
    }

    public boolean isValidCustomer(){
        return this.customerInfo != null && this.customerInfo.isValid();
    }

    public int getQuantityTotal(){
        int quantity = 0;
        for (CartLineInfo line : this.cartLines){
            quantity += line.getQuantity();
        }
        return quantity;
    }

    public double getAmountTotal(){
        double total = 0;
        for (CartLineInfo line : this.cartLines){
            total += line.getAmount();
        }
        return total;
    }

    public void updateQuantity(CartInfo cartForm){
        if (cartForm != null){
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines){
                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
            }
        }
    }

    public CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public void setOrderNum(int orderNum) {
    }
}
