package com.org.RestaurantManagementSystem.repository;

import com.org.RestaurantManagementSystem.model.OrderInfo;
import com.org.RestaurantManagementSystem.model.ProductInfo;
import com.org.RestaurantManagementSystem.pagination.PaginationResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RmsPagingAndSortingRepository extends CrudRepository<ProductInfo, String> {
    /*String sql =  "Select new " + OrderInfo.class.getName()//
            + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
            + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
            + Order.class.getName() + " ord "//
            + " order by ord.orderNum desc"; */

    List<OrderInfo> listOrderInfo();
}
