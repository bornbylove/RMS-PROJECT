package com.org.RestaurantManagementSystem.repository;

import com.org.RestaurantManagementSystem.model.OrderInfo;
import com.org.RestaurantManagementSystem.pagination.PaginationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, String> {
    @Query(value = "SELECT id, orderDate, orderNum, amount, customerName, customerAddress" +
            "customerEmail, customerPhone FROM OrderInfo")
    public List<OrderInfo> listOrderInfo();
}
