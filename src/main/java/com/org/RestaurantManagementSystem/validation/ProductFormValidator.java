package com.org.RestaurantManagementSystem.validation;

import com.org.RestaurantManagementSystem.dao.ProductDao;
import com.org.RestaurantManagementSystem.entity.Product;
import com.org.RestaurantManagementSystem.form.ProductForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductFormValidator implements Validator {

    private ProductDao productDao;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ProductForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
    ProductForm productForm = (ProductForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.productForm.code");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.productForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.productForm.price");

        String code = productForm.getCode();
        if (code != null && code.length() > 0){
            if (code.matches("\\s+")){
                errors.rejectValue("code", "Pattern.productForm.code");
            }
            else if (productForm.isNewProduct()){
                Product product = productDao.findProduct(code);
                if (product !=null){
                    errors.rejectValue("code", "Duplicate.productForm.code");
                }
            }
        }
    }
}
