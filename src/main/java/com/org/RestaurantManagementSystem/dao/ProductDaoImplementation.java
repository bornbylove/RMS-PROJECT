package com.org.RestaurantManagementSystem.dao;

import com.org.RestaurantManagementSystem.entity.Product;
import com.org.RestaurantManagementSystem.form.ProductForm;
import com.org.RestaurantManagementSystem.model.ProductInfo;
import com.org.RestaurantManagementSystem.repository.ProductDaoRepository;
import com.org.RestaurantManagementSystem.repository.RmsPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.Date;

public class ProductDaoImplementation implements ProductDao{
    @Autowired
    private ProductDaoRepository productDaoRepository;
    @Autowired
    private RmsPagingAndSortingRepository rmsPagingAndSortingRepository;
    @Override
    public Product findProduct(String code) {
       return productDaoRepository.findProduct(code);
    }

    @Override
    public void save(ProductForm productForm) {
        String code = productForm.getCode();
        Product product = null;
        boolean isNew = false;
        if(code != null){
            product = this.findProduct(code);
        }
        if (product == null){
            isNew = true;
            product = new Product();
            product.setCreateDate(new Date());
        }
        product.setCode(code);
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());

        if (productForm.getFileData() != null){
            byte[] image = null;
            try{
                image = productForm.getFileData().getBytes();
            } catch (IOException ignored) {
            }

            if (image != null && image.length > 0){
                product.setImage(image);
            }
        }
        if (isNew){
            productDaoRepository.save(product);
        }
    }

    @Override
    public ProductInfo findProductInfo(String code) {
        Product product = this.findProduct(code);
        if (product == null){
            return null;
        }
        return new ProductInfo(product.getCode(), product.getName(), product.getPrice());
    }

    @Override
    public Page<ProductInfo> getListOfProducts(Integer pageNumber,
                                               Integer pageSize,
                                               String sortProperty) {
        Pageable pageable = null;
        if (sortProperty != null){
            pageable = (Pageable) PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
        }
        else{
            pageable = (Pageable) PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
        }
        return (Page<ProductInfo>) rmsPagingAndSortingRepository.findAll();
    }
}
