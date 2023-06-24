package com.org.RestaurantManagementSystem.dao;

import com.org.RestaurantManagementSystem.entity.Order;
import com.org.RestaurantManagementSystem.model.CartInfo;
import com.org.RestaurantManagementSystem.model.OrderDetailInfo;
import com.org.RestaurantManagementSystem.model.OrderInfo;
import com.org.RestaurantManagementSystem.pagination.PaginationResult;

import java.util.List;

public interface OrderDao {
    public int getMaxOrderNum();

    public void saveOrder(CartInfo cartInfo);

    //public PaginationResult<OrderInfo> listOrderInfo(String code);

    public List<OrderInfo> listOrderInfo(String code);

    public Order findOrder(String orderId);

    public OrderInfo getOrderInfo(String orderId);

    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}

