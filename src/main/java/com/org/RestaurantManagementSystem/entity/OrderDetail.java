package com.org.RestaurantManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.SessionFactory;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Order_Details")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 7550745928843183535L;
    private SessionFactory sessionFactory;
    @Id
    @Column(name = "ID", length = 50, nullable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_code", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Amount", nullable = false)
    private double amount;

}
