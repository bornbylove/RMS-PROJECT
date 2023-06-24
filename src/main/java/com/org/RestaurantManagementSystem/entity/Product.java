package com.org.RestaurantManagementSystem.entity;

import com.org.RestaurantManagementSystem.repository.ProductDaoRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "Product")
@Data
public class Product implements Serializable {

    //@Transient
    @Autowired
    private ProductDaoRepository productDaoRepository;
    @Serial
    private static final long serialVersionUID = -1000119078147252957L;

    @Id
    @Column(name = "Code", length = 20, nullable = false)
    private String code;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private double price;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;
}
