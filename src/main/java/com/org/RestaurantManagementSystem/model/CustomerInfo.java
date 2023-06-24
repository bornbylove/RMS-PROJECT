package com.org.RestaurantManagementSystem.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
public class CustomerInfo {
    private String name;
    private String address;
    private String email;
    private String phone;

    private boolean valid;

    public void setValid(boolean valid){
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone(){
        return this.phone;
    }
}