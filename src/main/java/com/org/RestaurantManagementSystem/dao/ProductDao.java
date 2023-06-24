package com.org.RestaurantManagementSystem.dao;

import com.org.RestaurantManagementSystem.entity.Product;
import com.org.RestaurantManagementSystem.form.ProductForm;
import com.org.RestaurantManagementSystem.model.ProductInfo;
import org.springframework.data.domain.Page;

public interface ProductDao {
    public Product findProduct(String code);

    public void save(ProductForm productForm);
    public ProductInfo findProductInfo(String code);
    public Page<ProductInfo> getListOfProducts(Integer pageNumber, Integer pageSize, String sortProperty);
}
