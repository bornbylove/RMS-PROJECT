package com.org.RestaurantManagementSystem.repository;

import com.org.RestaurantManagementSystem.entity.Account;
import com.org.RestaurantManagementSystem.entity.Order;
import com.org.RestaurantManagementSystem.entity.OrderDetail;
import com.org.RestaurantManagementSystem.model.OrderDetailInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("OrderDaoRepository")
@Transactional
public interface OrderDaoRepository extends CrudRepository<OrderDetail, String> {
    @Query(value = "SELECT MAX(orderNum) FROM Order")
    public int getMaxOrderNum();

   /* String listorderSql = "Select new " + OrderDetailInfo.class.getName() //
            + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
            + " from " + OrderDetail.class.getName() + " d "//
            + " where d.order.id = :orderId "; */
    @Query(value = "SELECT product.id, product.code, product.name, product.price, quantity, " +
            "price, amount FROM OrderDetail")
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
