package com.org.RestaurantManagementSystem.dao;

import com.org.RestaurantManagementSystem.entity.Order;
import com.org.RestaurantManagementSystem.entity.OrderDetail;
import com.org.RestaurantManagementSystem.entity.Product;
import com.org.RestaurantManagementSystem.model.*;
import com.org.RestaurantManagementSystem.pagination.PaginationResult;
import com.org.RestaurantManagementSystem.repository.OrderDaoRepository;
import com.org.RestaurantManagementSystem.repository.OrderInfoRepository;
import com.org.RestaurantManagementSystem.repository.RmsPagingAndSortingRepository;
import com.org.RestaurantManagementSystem.repository.RmsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderDaoImplementation implements OrderDao{
    @Autowired
    private OrderDetail orderDetail;
    @Autowired
    private RmsRepository rmsRepository;
    @Autowired
    private Order order;
    @Autowired
    private OrderDaoRepository orderDaoRepository;
    private OrderInfoRepository orderInfoRepository;

    private ProductDao productDao;
    @Autowired
    private RmsPagingAndSortingRepository rmsPagingAndSortingRepository;

    @Override
    public int getMaxOrderNum() {
        return orderDaoRepository.getMaxOrderNum();
    }

    @Override
    @Transactional
    public void saveOrder(CartInfo cartInfo) {
    int orderNum = this.getMaxOrderNum() + 1;

    order.setId(UUID.randomUUID().toString());
    order.setOrderNum(orderNum);
    order.setOrderDate(new Date());
    order.setAmount(cartInfo.getAmountTotal());

        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
    order.setCustomerName(customerInfo.getName());
    order.setCustomerEmail(customerInfo.getEmail());
    order.setCustomerPhone(customerInfo.getPhone());
    order.setCustomerAddress(customerInfo.getAddress());

        orderDaoRepository.save(orderDetail);

    List<CartLineInfo> lines = cartInfo.getCartLines();

    for (CartLineInfo line : lines){
        OrderDetail detail = new OrderDetail();
        detail.setId(UUID.randomUUID().toString());
        detail.setOrder(order);
        detail.setAmount(line.getAmount());
        detail.setPrice(line.getProductInfo().getPrice());
        detail.setQuantity(line.getQuantity());

        String code = line.getProductInfo().getCode();
        Product product = this.productDao.findProduct(code);
        detail.setProduct(product);
    }
    cartInfo.setOrderNum(orderNum);

    }

    @Override
    public List<OrderInfo> listOrderInfo(String code) {
        return orderInfoRepository.listOrderInfo();
        //return new PaginationResult<OrderInfo>();
    }

    @Override
    public Order findOrder(String orderId) {
     orderDaoRepository.findById(orderId);
     return new Order();
    }

    @Override
    public OrderInfo getOrderInfo(String orderId) {
        order = this.findOrder(orderId);
        if (order == null){
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(), //
                order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
                order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
    }

    @Override
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
        orderDaoRepository.listOrderDetailInfos(orderId);
        return new ArrayList<>();
    }
}
