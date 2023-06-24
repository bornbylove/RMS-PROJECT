package com.org.RestaurantManagementSystem.repository;

import com.org.RestaurantManagementSystem.entity.Product;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductDaoRepository extends JpaRepository<Product, String> {
    //String productSql = "Select e from " + Product.class.getName() + " e Where e.code =:code ";

    @Query("SELECT * from Product WHERE code = ?code")
    public Product findProduct(String code);
}
