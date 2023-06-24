package com.org.RestaurantManagementSystem.form;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class ProductForm {
    private String code;
    private String name;
    private double price;

    private boolean newProduct = false;
    private MultipartFile fileData;
}
