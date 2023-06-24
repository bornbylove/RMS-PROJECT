package com.org.RestaurantManagementSystem.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class CustomerForm {
    private String name;
    private  String address;
    private String email;
    private String phone;

    private boolean valid;
}
